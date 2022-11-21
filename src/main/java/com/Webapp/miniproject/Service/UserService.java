package com.Webapp.miniproject.Service;

import java.util.List;

import com.Webapp.miniproject.Dto.UserDto;

public interface UserService {

	UserDto addUser(UserDto userDto, String lang)throws Exception;

	List<UserDto> getAllUsers()throws Exception;

	UserDto getUserById(String id)throws Exception;

	UserDto updateUser(UserDto userDto, String lang)throws Exception;

	UserDto deleteUserById(String id)throws Exception;

}
