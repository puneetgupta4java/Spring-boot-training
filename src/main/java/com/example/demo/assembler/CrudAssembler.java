package com.example.demo.assembler;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.response.dto.UserResponseDto;

public class CrudAssembler {
	
	@Autowired
	UserResponseDto userResponseDto;
	
	public UserResponseDto toModel()
	{
		
		return null;
		
	}
}
