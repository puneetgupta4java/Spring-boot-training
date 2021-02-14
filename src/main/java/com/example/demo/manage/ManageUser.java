package com.example.demo.manage;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.OptionalUserAssembler;
import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.dto.UserResponseDto;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/search")
public class ManageUser {

	//Used to Set the Logging Level
	Logger logger = LoggerFactory.getLogger(ManageUser.class);
	
	//Added UserSerivce
	@Autowired
	private UserService userService;
	
	@Autowired
	OptionalUserAssembler opUserAssembler;
	
	@Autowired
	private UserAssembler userAssembler;

	@GetMapping(value = "/name", produces = {MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Find users by Name",
			notes="Provide a Name to lookup for specific User",
			response=UserResponseDto.class)
	  public ResponseEntity<UserResponseDto> searchUserByNames(@ApiParam(value = "Name of the User")@RequestParam("name") String name) throws JsonProcessingException 
		{
		logger.trace("Search Name Method Accessed");
		List<User> user= userService.searchUserByName(name);
		UserResponseDto response = userAssembler.toModel(user);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED); 
		}
	 
	@GetMapping(value = "/id", produces = {MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Find user by Id",
	notes="Provide an ID to lookup for specific User",
	response=UserDto.class)
	public ResponseEntity<UserDto> searchUserById(@ApiParam(value="Id value for the User u want to retrieve",required=true)
	@RequestParam("id") String id) throws JsonProcessingException {
		Optional<User> user = userService.searchUserById(id);
		UserDto response = opUserAssembler.toModel(user);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}

	
	@GetMapping(value = "/project", produces = {MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value="Find users on a Project", 
	notes="Search users working on a Project")
	public ResponseEntity<UserResponseDto> searchbyProjectName(@ApiParam(value="Enter Project Name")@RequestParam("project") String project) throws JsonProcessingException {
	    List<User> user = userService.searchbyProjectName(project);
	    UserResponseDto response = userAssembler.toModel(user);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED); 
	}
	
	@ApiIgnore
	@GetMapping(value = "/allprojects", produces = {MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value="Find all Projects",
	notes="Search for all projects in the Company")
	public ResponseEntity<Set<String>> searchbyClickProject() throws JsonProcessingException {
		Set<String> jsonInString = userService.searchbyClickProject();
		return new ResponseEntity<>(jsonInString,HttpStatus.ACCEPTED);
	}
}
