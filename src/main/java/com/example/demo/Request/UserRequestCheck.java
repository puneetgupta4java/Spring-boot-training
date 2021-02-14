package com.example.demo.Request;


import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.example.demo.model.User;


@Component
public class UserRequestCheck {
	public boolean isJsonValid(User user)
	{
		try {
			
			new JSONObject(user);
		     return true;
		}
		catch (Exception e)
		{
			
			return false;
			
		}
	}
	
	public boolean isJsonArrayValid(List<User> User)
	{
		try {
			new JSONArray(User);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	}
