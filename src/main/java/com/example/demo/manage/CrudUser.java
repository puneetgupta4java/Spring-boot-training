package com.example.demo.manage;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.UpdateUserAssembler;
import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.dto.UserResponseDto;
import com.example.demo.service.CrudService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.bytebuddy.implementation.bind.annotation.Pipe;


//Added Code to perform CRUD operations

@RestController
@RequestMapping(value= {"crud"})
public class CrudUser  {
	
	@Autowired 
	private CrudService crudService;
	
	@Autowired
	private UpdateUserAssembler updateUserAssembler;
	
	@Autowired
	private UserAssembler userAssembler;
	
	//One DataSet will be updated at a Time
	@PutMapping(value={"update"},consumes= MediaType.APPLICATION_JSON_VALUE,produces = { "application/json" })
	@ApiOperation(value="Update the User By ID",
	notes="Enter the Data in JSON Format to Update User",
	response=UserDto.class)
	public ResponseEntity<UserDto> saveorUpdateUser(@ApiParam(value="User Data in JSON Format")@RequestBody User user)
	{
		User usr = crudService.saveOrUpdateUser(user);
		UserDto response = updateUserAssembler.toModel(usr);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED) ;
	}
	
	
	@PostMapping(value={"add"},consumes= MediaType.APPLICATION_JSON_VALUE,produces = { "application/json" })
	@ApiOperation(value="Add User",
	notes="Enter User Data in JSON Array Format",
	response=UserResponseDto.class)
	public ResponseEntity<UserResponseDto> addUser(@ApiParam(value="User Data in JSON Format")@RequestBody List<User> user)
	{
		List<User> users = crudService.addUser(user);
		UserResponseDto response = userAssembler.toModel(users);
		return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value= {"/delete/{id}"})
	@ApiOperation(value="Delete User by ID",
	notes="Enter User ID to remove User")
	public ResponseEntity<String> deleteUser(@ApiParam(value="Enter UserID")@PathVariable("id") String id)
	{
		String s= crudService.deleteUser(id);
		return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
	}
}
