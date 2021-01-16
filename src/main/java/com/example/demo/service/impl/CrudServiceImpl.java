package com.example.demo.service.impl;

import com.example.demo.Request.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CrudService;

@Component
public class CrudServiceImpl implements CrudService {
	
	@Autowired
	UserRepository userRepositry;
	
	@Autowired
	UserRequestCheck userRequestCheck;

	@Override
	public User getsaveorUpdateUser(User user) {
		
		if(user == null)
		{
			throw new UserException("Please enter user data to be updated");
		}
		
		  else if (!userRequestCheck.isJsonValid(user)) { 
			String str1=
		  "{\n\t\"id\": 123456\",\n\t\"name\": \"Ashi\"\n\t}"
		  ; throw new UserException("Something wrong with JSON Format. Valid Format" +
		  str1); }
		 
		else if(user!= null && userRepositry.existsById(user.getId()) )
		{
			//Optional<User> opUser = Optional.ofNullable(userRepositry.save(user)) ;
			return userRepositry.save(user);
		}
		
		else 
			throw new UserException("Kuch toh Gadbad h dyaa");
	}

	@Override
	public List<User> getaddUser(List<User> user)
	{
		if(userRequestCheck.isJsonArrayValid(user) == false)
				{	
					String str1= "\n[\n\t{\n\t\"id\": 123456\",\n\t\"name\": \"Ashi\"\n\t},\n\t {\n\t\"id\": 7890123\",\n\t\"name\": \"Bindal\"\n\t},\n\t.\n\t.\n]";

					throw new UserException("Something wrong with JSON Format. Correct Format is: "+str1);
				}
		else if(CollectionUtils.isEmpty(user))
		{
			throw new UserException("Please enter valid user Data to be added");
		}
		else {
			return userRepositry.saveAll(user);
		}
	}
	
	public String getdeleteUser(String id)
	{
		if(id == null ||id.trim().isEmpty())
		{
			throw new UserException("Please enter valid ID");
		}
		userRepositry.deleteById(id);
		return "Data Deleted Successfully";
	}

}
