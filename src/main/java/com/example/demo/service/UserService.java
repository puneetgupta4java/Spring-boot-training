//Added UserService

package com.example.demo.service;



import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserService {
	
	public List<User> searchUserByName(String name);
	public Optional<User> searchUserById(String id) throws JsonProcessingException;	
	public List<User> searchbyProjectName(String project) throws JsonProcessingException;
	public Set<String> searchbyClickProject() throws JsonProcessingException;
	}