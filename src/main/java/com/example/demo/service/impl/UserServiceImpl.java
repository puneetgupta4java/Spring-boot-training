package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getsearchUserByName(String name)
	{
		//Handling Null
				if(name == null || name.trim().isEmpty())
				{
					throw new UserException("User name cannot be null or empty"); 
				}
				List<User> users= userRepository.findByName(name);	
				if(CollectionUtils.isEmpty(users))
				{
					throw new UserException("User name not found in Database");
				}
				return users;
				
	}
	
	
	public Optional<User> getsearchUserById(String id) throws JsonProcessingException {
		System.out.println(id);
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
	    	throw new UserException("User Data not found in Database");
	    }
	}
	
	public List<User> getsearchbyProjectName(String project) throws JsonProcessingException {
		if(project == null || project.trim().isEmpty())
		{
			throw new UserException("Project Name cannot be null or empty"); 
		}
		List<User> users = userRepository.findByProject(project);
		if(CollectionUtils.isEmpty(users))
		{
			throw new UserException("No Data found");
		}
	    return users;
	}
	
	public List<String> getsearchbyClickProject() throws JsonProcessingException {
		ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
		
		  Set<String> projects = new HashSet<String>(); 
		  for(User u : users) {
		  System.out.println(u.getProject().getClass().getName());
		  projects.add(u.getProject());
		  }
		  
		 // List<User> list = new ArrayList<>(projects);
		 
		return projects.stream().collect(Collectors.toList());
	}
	
}
