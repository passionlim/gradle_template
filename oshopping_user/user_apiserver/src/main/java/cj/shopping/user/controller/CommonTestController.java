package cj.shopping.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cj.oshopping.common.CommonLibApplication;

@Controller
public class CommonTestController {
	
	@RequestMapping
	public String index(String message) {
		Class clazz = CommonLibApplication.class;
		
		return "hello world! " + message;
	}
}
