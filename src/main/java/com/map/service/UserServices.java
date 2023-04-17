package com.map.service;

import java.util.List;

import com.map.dto.StatusDto;
import com.map.dto.UserDto;
import com.map.entity.User;

public interface UserServices {

	public Object saveUserInformation(UserDto userdto);

	public Object findUserById(int id) throws Exception;

	public List<UserDto> getAlluser();

	public String deleteUserbyid(int id);

	public User updateUserById(int id, UserDto userDTO) throws Exception;
	
	public String updateUserStatus(int id, StatusDto statusDto) throws Exception;

}