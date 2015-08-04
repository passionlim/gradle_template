package cj.shopping.user.apiserver.controller;

import org.springframework.web.bind.annotation.RestController;

import cj.oshopping.user.api.spec.HelloWorld;

@RestController
public class HelloworldController implements HelloWorld {
	
	@Override
	public String helloWorld(String message) {
		return "hello1 world " + message;
	}

	@Override
	public String helloWorld2(String message) {
		return "hello12 world " + message;
	}
}
