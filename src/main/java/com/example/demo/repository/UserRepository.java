package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;


public interface UserRepository  extends JpaRepository<User,String>{

	List<User> findByName(String emp_name);
	
	List<User> findByProject(String emp_project);

}
