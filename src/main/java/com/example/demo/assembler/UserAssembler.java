package com.example.demo.assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.dto.UserResponseDto;

@Component
public class UserAssembler {
	
	public UserResponseDto toModel(List<User> users, Optional<User> opUser)
	{
		UserResponseDto userResponse = new UserResponseDto();
		UserDto userDto = new UserDto();
		List<UserDto> userDtolist = new ArrayList<>();
		
		if(CollectionUtils.isEmpty(users) && opUser.isPresent()== true)
		{
			userDto.setName(opUser.get().getName());
			userDto.setDesignation(opUser.get().getDesignation());
			userDto.setDu(opUser.get().getDu());
			userDto.setExtension(opUser.get().getExtension());
			userDto.setImg(opUser.get().getImg());
			userDto.setImgurl(opUser.get().getImgurl());
			userDto.setMail(opUser.get().getMail());
			userDto.setOracleid(opUser.get().getOracleid());
			userDto.setProject(opUser.get().getProject());
			userDto.setSeat(opUser.get().getSeat());
			
			userDtolist.add(userDto);
			
		}
		else if(CollectionUtils.isEmpty(users) ==false && opUser.isPresent() == false)
		{
				for(User s: users)
				{
					System.out.println(s.getId());
					
					userDto.setName(s.getId());
					userDto.setDesignation(s.getDesignation());
					userDto.setDu(s.getDu());
					userDto.setExtension(s.getExtension());
					userDto.setImg(s.getImg());
					userDto.setImgurl(s.getImgurl());
					userDto.setMail(s.getMail());
					userDto.setOracleid(s.getOracleid());
					userDto.setProject(s.getProject());
					userDto.setSeat(s.getSeat());
					
					userDtolist.add(userDto);
				}
			
		}
		else {
			return userResponse;
		}
		userResponse.setUsers(userDtolist);
		return userResponse;
	}
}
