package com.example.demo.assembler;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;

@Component
public class OptionalUserAssembler {
	
	UserDto userDto = new UserDto();
	
	public UserDto toModel( Optional<User> opUser)
	{	
		User user = opUser.get();
		
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
