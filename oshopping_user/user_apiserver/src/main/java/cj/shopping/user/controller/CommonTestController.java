package cj.shopping.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cj.oshopping.common.CommonLibApplication;
import cj.oshopping.user.model.WebMember;

@Controller
public class CommonTestController {
	
	@RequestMapping
	public String index(String message) {
		Class clazz = CommonLibApplication.class;

		WebMember webMember = new WebMember();
		webMember.setCustNo("");

		return "hello world! " + message;
		
	}
}
