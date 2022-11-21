package com.Webapp.miniproject.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Webapp.miniproject.MovieConstants;
import com.Webapp.miniproject.Dto.UserDto;
import com.Webapp.miniproject.Entity.User;
import com.Webapp.miniproject.Repository.UserRepository;
import com.Webapp.miniproject.Service.CommonService;
import com.Webapp.miniproject.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	CommonService commonService;

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto login(String email, String password, String lang) throws Exception {
		
		UserDto resultDto = new UserDto();

		User user = userRepository.findByEmail(email);

		if (user == null) {
			resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
			resultDto.setMessage("invalid email");

			logger.info(resultDto.getMessage());
			return resultDto;
		}

		if (!password.equals(user.getPassword())) { 
			resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
			resultDto.setMessage("password invalid");

			logger.info(resultDto.getMessage());
			return resultDto;
		}

		resultDto.setId(user.getId());
		resultDto.setEmail(user.getEmail());
		resultDto.setFirstName(user.getFirstName());
		resultDto.setLastName(user.getLastName());
		resultDto.setPhoneNumber(user.getPhoneNumber());
		resultDto.setPassword(user.getPassword());
		resultDto.setCountry(user.getCountry());
	
		resultDto.setStatus(MovieConstants.RETURN_STATUS_OK);
		resultDto.setMessage("Login Successfully");

		return resultDto;
	}

}
