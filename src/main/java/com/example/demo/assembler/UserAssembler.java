package com.example.demo.assembler;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.example.demo.model.User;
import com.example.demo.response.dto.UserDto;
import com.example.demo.response.dto.UserResponseDto;

@Component
public class UserAssembler  {

	UserResponseDto userResponse = new UserResponseDto();
	
	public UserResponseDto toModel(List<User> users)
	{
		
		List<UserDto> userDtolist2 = users.stream().map(
				(usr) -> 
				{	
					UserDto userDto = new UserDto();
					userDto.setName(usr.getName());
					userDto.setDesignation(usr.getDesignation());
					userDto.setDu(usr.getDu());
					userDto.setExtension(usr.getExtension());
					userDto.setImg(usr.getImg());
					userDto.setImgurl(usr.getImgurl());
					userDto.setMail(usr.getMail());
					userDto.setOracleid(usr.getOracleid());
					userDto.setProject(usr.getProject());
					userDto.setSeat(usr.getSeat());
					return userDto;

				}).collect(Collectors.toList());
		
		userResponse.setUsers(userDtolist2);
		return userResponse;
	}
	
	
}
