//Added UserService

package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public interface UserService {
	
	
	//Removed Object Mapper
	public List<User> getsearchUserByName(String name);
	public Optional<User> getsearchUserById(String id) throws JsonProcessingException;	
	public List<User> getsearchbyProjectName(String project) throws JsonProcessingException;
	public List<String> getsearchbyClickProject() throws JsonProcessingException;
	}