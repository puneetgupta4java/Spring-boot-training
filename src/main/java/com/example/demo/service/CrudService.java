package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface CrudService {
	public User saveOrUpdateUser(User user);
	public String deleteUser(String id);
	public List<User> addUser(List<User> user);
}
