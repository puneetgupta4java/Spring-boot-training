package com.example.demo.manage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.response.dto.UserResponseDto;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value = "/search")
public class ManageUser {

	
	//Added UserSerivce
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAssembler userAssembler;

	//@RequestMapping(value = "/name",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	//public String searchUserByName(@RequestParam("name") String name) throws JsonProcessingException {
		/*
		 * List<User> users = userRepository.findByName(name); ObjectMapper mapper = new
		 * ObjectMapper(); String jsonInString = null; jsonInString =
		 * mapper.writeValueAsString(users); return jsonInString;
		 */
	//}
	
	@GetMapping(value = "/name", produces = {MediaType.APPLICATION_JSON_VALUE })
	  public ResponseEntity<UserResponseDto> searchUserByNames(@RequestParam("name") String name) throws JsonProcessingException 
		{
		List<User> user= userService.getsearchUserByName(name);
		UserResponseDto response = userAssembler.toModel(user,Optional.ofNullable(null));
		HttpHeaders responseHeaders = new HttpHeaders(); 
		return new ResponseEntity<>(response,responseHeaders,HttpStatus.ACCEPTED); 
		}
	 
		
		//@RequestMapping(value = "/name",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE })
	/*
	 * public String searchUserByNames(@RequestParam("name") String name) throws
	 * JsonProcessingException { String jsonInString=
	 * userService.getsearchUserByName(name); //HttpHeaders responseHeaders = new
	 * HttpHeaders(); return jsonInString; }
	 */
	

	@GetMapping(value = "/id", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseDto> searchUserById(@RequestParam("id") String id) throws JsonProcessingException {
		Optional<User> user = userService.getsearchUserById(id);
		UserResponseDto response = userAssembler.toModel(null,user);
		HttpHeaders respHeaders= new HttpHeaders();
		return new ResponseEntity<>(response,respHeaders,HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "/project", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseDto> searchbyProjectName(@RequestParam("project") String project) throws JsonProcessingException {
	    List<User> user = userService.getsearchbyProjectName(project);
	    UserResponseDto response = userAssembler.toModel(user,Optional.ofNullable(null));
		HttpHeaders responseHeaders = new HttpHeaders(); 
		return new ResponseEntity<>(response,responseHeaders,HttpStatus.ACCEPTED); 
	}
	
	@GetMapping(value = "/allprojects", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<String>> searchbyClickProject() throws JsonProcessingException {
		List<String> jsonInString = userService.getsearchbyClickProject();
		HttpHeaders respHeaders= new HttpHeaders();
		return new ResponseEntity<>(jsonInString,respHeaders,HttpStatus.ACCEPTED);
	}
}
