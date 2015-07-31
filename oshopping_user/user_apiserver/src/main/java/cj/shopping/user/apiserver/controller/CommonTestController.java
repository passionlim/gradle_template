package cj.shopping.user.apiserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonTestController {
	
	@RequestMapping("/hello")
	public String index(String message) {
		return "hello world! broken " + message;
	}
}
