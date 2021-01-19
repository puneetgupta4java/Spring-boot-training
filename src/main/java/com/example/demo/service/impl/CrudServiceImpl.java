package com.example.demo.service.impl;

import com.example.demo.Request.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.commons.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CrudService;

@Service	
public class CrudServiceImpl implements CrudService {
	
	@Autowired
	UserRepository userRepositry;
	
	@Autowired
	UserRequestCheck userRequestCheck;

	@Override
	public User saveOrUpdateUser(User user) {

		if (!userRequestCheck.isJsonValid(user)) { 
					
			throw new UserException("Something wrong with JSON Format. Valid Format" +Constants.JSON_STRING);
			}

		else if (user == null || !userRepositry.existsById(user.getId()))
		{
			throw new UserException("Please enter correct user data to be updated in the format: " +Constants.JSON_STRING);
		}

		else if(user!= null && userRepositry.existsById(user.getId()) )
		{
			return userRepositry.save(user);
		}

		else 
			throw new UserException("Kuch toh Gadbad h dyaa");
	}

	@Override
	public List<User> addUser(List<User> user)
	{
		if(userRequestCheck.isJsonArrayValid(user) == false)
				{	
					throw new UserException("Something wrong with JSON Format. Correct Format is: "+Constants.JSON_ARR_STR);
				}
		else if(CollectionUtils.isEmpty(user))
		{
			throw new UserException("Please enter valid user Data to be added");
		}
		else {
			return userRepositry.saveAll(user);
		}
	}
	
	public String deleteUser(String id)
	{
		if(id == null ||id.trim().isEmpty())
		{
			throw new UserException("Please enter valid ID");
		}
		else if (!userRepositry.existsById(id))
		{
			throw new UserException("User does not exist with provided ID");
		}
		userRepositry.deleteById(id);
		return "Data Deleted Successfully";
	}

}
