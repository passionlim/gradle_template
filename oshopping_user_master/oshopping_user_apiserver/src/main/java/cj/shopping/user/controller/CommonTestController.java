package cj.shopping.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonTestController {
	
	@RequestMapping
	public String index(String message) {
		return "hello world! " + message;
	}
}
