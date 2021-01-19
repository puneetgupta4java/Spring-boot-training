package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> searchUserByName(String name)
	{
		//Handling Null
				if(name == null || name.trim().isEmpty())
				{
					throw new UserException("User name cannot be null or empty"); 
				}
				List<User> users= userRepository.findByName(name);	
				if(CollectionUtils.isEmpty(users))
				{
					throw new UserException("User name not found in Database",HttpStatus.NOT_FOUND);
				}
				return users;
				
	}
	
	
	public Optional<User> searchUserById(String id) throws JsonProcessingException {
	
		if(id == null || id.trim().isEmpty())
		{
			throw new UserException("ID cannot be null or empty"); 
		}
	    
		Optional<User> optionalUser = userRepository.findById(id);
	    
		
		  //Handled Null Value 
		if(optionalUser.isPresent()) 
		{
			return optionalUser; 
		}
		
		else 
		{ 
			throw new
			UserException("User Data not found in Database",HttpStatus.NOT_FOUND);
		}
		 
	}
	
	public List<User> searchbyProjectName(String project) throws JsonProcessingException {
		if(project == null || project.trim().isEmpty())
		{
			throw new UserException("Project Name cannot be null or empty",HttpStatus.NO_CONTENT); 
		}
		List<User> users = userRepository.findByProject(project);
		if(CollectionUtils.isEmpty(users))
		{
			throw new UserException("No Data found",HttpStatus.NOT_FOUND);
		}
	    return users;
	}
	
	public Set<String> searchbyClickProject() throws JsonProcessingException {
		ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
		  
		return users.stream().map(u -> u.getProject()).collect(Collectors.toSet());
	}
	
}
