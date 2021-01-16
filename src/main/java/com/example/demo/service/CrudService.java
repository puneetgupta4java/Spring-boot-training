package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.User;

@Service
public interface CrudService {
	public User getsaveorUpdateUser(User user);
	public String getdeleteUser(String id);
	public List<User> getaddUser(List<User> user);
}
