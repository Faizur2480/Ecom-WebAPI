package com.Webapp.miniproject.Service;

import com.Webapp.miniproject.Dto.UserDto;

public interface LoginService {

	UserDto login(String email, String password, String lang)throws Exception;

}
