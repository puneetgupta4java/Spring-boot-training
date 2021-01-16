package com.example.demo.Request;


import java.util.List;

import org.json.Cookie;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
//import play.libs.Json;
//import com.google.gson.JsonParser;

@Component
public class UserRequestCheck {
	public boolean isJsonValid(User user)
	{
		try {
			/*
			 * final ObjectMapper mapper = new ObjectMapper(); mapper.readTree(User);
			 */
			
			new JSONObject(user);
		     return true;
		}
		catch (Exception e)
		{
			
			return false;
			/*
			 * try { Cookie.toJSONObject(User); return true; } catch (Exception e2) {
			 * System.out.println("Invalid JSON"); }
			 */
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
