package com.example.demo.manage;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.model.User;
import com.example.demo.response.dto.UserResponseDto;
import com.example.demo.service.CrudService;


//Create/Update/Delete User by ID

//@SuppressWarnings("all")
@RestController
@RequestMapping(value= {"Crud","crud","CRUD"})
public class CrudUser  {
	
	@Autowired
	private CrudService crudService;
	
	/*
	 * @Autowired private UserAssembler userAssembler;
	 */
	
	@PutMapping(value={"update","change","set"})
	public ResponseEntity<User> saveorUpdateUser(@RequestBody User user)
	{
		User usr = crudService.getsaveorUpdateUser(user);
		//UserResponseDto response = userAssembler.toModel(null, usr);
		HttpHeaders responseHeaders = new HttpHeaders(); 
		return new ResponseEntity<>(usr,responseHeaders,HttpStatus.ACCEPTED) ;
	}
	
	@PostMapping(value={"add","save"})
	public ResponseEntity<List<User>> addUser(@RequestBody List<User> user)
	{
		List<User> users = crudService.getaddUser(user);
		HttpHeaders responseHeaders = new HttpHeaders(); 
		return new ResponseEntity<>(users,responseHeaders,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value= {"/delete/{id}","/remove{id}"})
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id)
	{
		String s= crudService.getdeleteUser(id);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(s,responseHeaders,HttpStatus.ACCEPTED);
	}
}
