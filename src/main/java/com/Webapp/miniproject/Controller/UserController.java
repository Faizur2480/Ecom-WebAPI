package com.Webapp.miniproject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Webapp.miniproject.MovieConstants;
import com.Webapp.miniproject.MovieUtil;
import com.Webapp.miniproject.Dto.UserDto;
import com.Webapp.miniproject.Service.UserService;

@CrossOrigin("*")
@RequestMapping("/api")
@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public UserDto addUser(@RequestBody UserDto userDto,
			@RequestHeader(name = "lang", required = false) String lang) {

		UserDto resultDto = new UserDto();
		try {

			// Mandatory check.
			StringBuilder errorParam = new StringBuilder();
			// Email
			if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
				errorParam.append("Email");
			}
			// First Name
			if (userDto.getFirstName() == null || userDto.getLastName().isEmpty()) {
				errorParam.append("First Name");
			}
			// Last Name
			if (userDto.getLastName() == null || userDto.getLastName().isEmpty()) {
				errorParam.append("Last Name");
			}
			// Phone Number
			if (userDto.getPhoneNumber() == null || userDto.getPhoneNumber().isEmpty()) {
				errorParam.append("Phone Number");
			}
			//Country
			if (userDto.getCountry() == null || userDto.getCountry().isEmpty()) {
				errorParam.append("country");
			}
			//State
//			if (userDto.getState() == null || userDto.getState().isEmpty()) {
//				errorParam.append("Last Name");
//			}
			//Password
			if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
				errorParam.append("password");
			}
//			if (errorParam.length() > 0) {
//				resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
//				resultDto.setMessage(
//						super.getMessage("mandatory.input.param", new String[] { errorParam.toString() }, lang));
//
//				logger.info(resultDto.getMessage());
//				return resultDto;
//			}

			resultDto = userService.addUser(userDto, lang);

		} catch (final Exception e) {

			resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
			resultDto.setMessage(e.getMessage());

			logger.error(MovieUtil.getErrorMessage(e));
		}

		return resultDto;
	}

	@GetMapping("/getAllUsers")
	public List<UserDto> getAllUsers(@RequestHeader(name = "lang", required = false) String lang) {

		try {

			return userService.getAllUsers();

		} catch (final Exception e) {
			logger.error(MovieUtil.getErrorMessage(e));
		}

		return new ArrayList<UserDto>();
	}
	@GetMapping("/getUserById/{id}")
	public UserDto getUserById(@PathVariable String id,
			@RequestHeader(name = "lang", required = false) String lang) {

		UserDto userDto = new UserDto();
		try {
			userDto = userService.getUserById(id);
		} catch (final Exception e) {
			logger.error(MovieUtil.getErrorMessage(e));
		}

		return userDto;
	}
	@PutMapping("/updateUser")
	public UserDto updateUser(@RequestBody UserDto userDto,
			@RequestHeader(name = "lang", required = false) String lang) {

		UserDto resultDto = new UserDto();
		try {

			// Mandatory check.
			StringBuilder errorParam = new StringBuilder();
			// Email
			if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
				errorParam.append("Email");
			}
			// First Name
			if (userDto.getFirstName() == null || userDto.getLastName().isEmpty()) {
				errorParam.append("First Name");
			}
			// Last Name
			if (userDto.getLastName() == null || userDto.getLastName().isEmpty()) {
				errorParam.append("Last Name");
			}
			// PhoneNumber
//			if (userDto.getPhoneNumber() == null || userDto.getPhoneNumber().isEmpty()) {
//				errorParam.append("Last Name");
//			}
			//Country
			if (userDto.getCountry() == null || userDto.getCountry().isEmpty()) {
				errorParam.append("Last Name");
			}
			//State
//			if (userDto.getState() == null || userDto.getState().isEmpty()) {
//				errorParam.append("Last Name");
//			}
			//Password
			if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
				errorParam.append("Last Name");
			}
//			if (errorParam.length() > 0) {
//				resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
//				resultDto.setMessage(
//						super.getMessage("mandatory.input.param", new String[] { errorParam.toString() }, lang));
//
//				logger.info(resultDto.getMessage());
//				return resultDto;
//			}


			resultDto = userService.updateUser(userDto, lang);

		} catch (final Exception e) {

			resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
			resultDto.setMessage(e.getMessage());

			logger.error(MovieUtil.getErrorMessage(e));
		}

		return resultDto;
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public UserDto deleteUserById(@PathVariable String id,
			@RequestHeader(name = "lang", required = false) String lang) {

		UserDto resultDto = new UserDto();
		try {

			return userService.deleteUserById(id);

		} catch (final Exception e) {

			resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
			resultDto.setMessage(e.getMessage());

			logger.error(MovieUtil.getErrorMessage(e));

			return resultDto;
		}
	}
}