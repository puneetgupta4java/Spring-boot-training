package com.example.demo.assembler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;

@Component
public class UpdateUserAssembler {
	
	@Autowired
	UserDto userDto;
	
	public UserDto toModel(User user)
	{	
			userDto.setName(user.getName());
			userDto.setDesignation(user.getDesignation());
			userDto.setDu(user.getDu());
			userDto.setExtension(user.getExtension());
			userDto.setImg(user.getImg());
			userDto.setImgurl(user.getImgurl());
			userDto.setMail(user.getMail());
			userDto.setOracleid(user.getOracleid());
			userDto.setProject(user.getProject());
			userDto.setSeat(user.getSeat());
			
			return userDto;
		
	}
	
}
