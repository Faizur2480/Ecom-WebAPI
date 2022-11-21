package com.Webapp.miniproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Webapp.miniproject.ServiceImpl.CommonServiceImpl;

@RestController
public class CommonController {

	@Autowired
	private CommonServiceImpl commonService;

	public String getMessage(String messageKey, String[] params, String language) throws Exception {

		return commonService.getMessage(messageKey, params, language);
	}
}
