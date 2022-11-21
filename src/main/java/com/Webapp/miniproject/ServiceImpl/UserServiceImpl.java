package com.Webapp.miniproject.ServiceImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Webapp.miniproject.Dto.UserDto;
import com.Webapp.miniproject.Entity.User;
import com.Webapp.miniproject.Repository.UserRepository;
import com.Webapp.miniproject.Service.CommonService;
import com.Webapp.miniproject.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CommonService commonService;
	
	@Override
	public UserDto addUser(UserDto userDto, String lang) throws Exception {
		
		UserDto resultDto = new UserDto();
		
		if(userRepository.findById(userDto.getId()) != null) {
		resultDto.setMessage("User Already Exist");
		resultDto.setStatus(1);
		return resultDto;
		}
		
		User user =new User();
		user.setId(commonService.nextSequenceNumber());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPhoneNumber(user.getPhoneNumber());
		user.setCountry(userDto.getCountry());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
		
		System.out.println("user added");
		resultDto.setMessage("Registered successfully");
		return resultDto;
	
	
	}

	@Override
	public List<UserDto> getAllUsers() throws Exception {
		
		List<User> UserLists = userRepository.findAll();
		
		List<UserDto> UserDtoList = new ArrayList<UserDto>();
		for (User User : UserLists) {
			UserDtoList.add(this.getUserDto(User));
		}

		return UserDtoList;
	}

	private UserDto getUserDto(User user) {
		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setPhoneNumber(user.getPhoneNumber());
		userDto.setCountry(user.getCountry());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	@Override
	public UserDto getUserById(String id) throws Exception {
		
		User user = userRepository.findById(Long.parseLong(id));

		return user != null ? this.getUserDto(user) : new UserDto();
	}

	@Override
	public UserDto updateUser(UserDto userDto, String lang) throws Exception {
		
		UserDto resultDto = new UserDto();
		System.out.println(userDto.getId());
		User user = userRepository.findById(userDto.getId());

		if (user == null) {

			resultDto.setMessage("User does not exist");
			return resultDto;
		}
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setCountry(userDto.getCountry());
		
		userRepository.save(user);
		resultDto.setMessage("Record Updated Successfully");
		return resultDto;
	}

	@Override
	public UserDto deleteUserById(String id) throws Exception {
		
		UserDto resultDto = new UserDto();
		User user = userRepository.findById(Long.parseLong(id));
		if (user == null) {

			resultDto.setMessage("data does not exist");
			return resultDto;
		}

		userRepository.delete(user);
		resultDto.setMessage("Record Deleted Successfully");
		return resultDto;
	}
}
