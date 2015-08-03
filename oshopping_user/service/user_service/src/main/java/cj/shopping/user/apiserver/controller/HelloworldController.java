package cj.shopping.user.apiserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloworldController {
	
	@RequestMapping
	public String index(String message) {
		return "hello world! " + message;
	}
}
