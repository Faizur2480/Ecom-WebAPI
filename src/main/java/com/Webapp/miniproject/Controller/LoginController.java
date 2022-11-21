package com.Webapp.miniproject.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Webapp.miniproject.MovieConstants;
import com.Webapp.miniproject.MovieUtil;
import com.Webapp.miniproject.Dto.UserDto;
import com.Webapp.miniproject.Service.LoginService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LoginController extends CommonController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public UserDto login(@RequestBody(required = true) UserDto userDto,
			@RequestHeader(name = "lang", required = false) String lang) {

		UserDto resultDto = new UserDto();
		try {

			// Mandatory check.
			StringBuilder errorParam = new StringBuilder();
			// Email.
			if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
				errorParam.append("Email");
			}
			// Password.
			if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
				errorParam.append(errorParam.length() > 0 ? ", Password" : "Password");
			}

//			if (errorParam.length() > 0) {
//				resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
//				resultDto.setMessage(
//						super.getMessage("mandatory.input.param", new String[] { errorParam.toString() }, lang));
//
//				logger.info(resultDto.getMessage());
//				return resultDto;
//			
//				
//			}
				resultDto = loginService.login(userDto.getEmail(), userDto.getPassword(), lang);
			
		} catch (final Exception e) {

			resultDto.setStatus(MovieConstants.RETURN_STATUS_ERROR);
			resultDto.setMessage(e.getMessage());

			logger.error(MovieUtil.getErrorMessage(e));
			return resultDto;
		}
		resultDto.setMessage("Login successfully");
		return resultDto;
	}
}
