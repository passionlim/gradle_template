package cj.shopping.user.apiserver.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cj.oshopping.user.model.WebMember;

@RestController
@RequestMapping("/users")
public class WebMemberController {
	
	@RequestMapping("/{custNo}")
	public WebMember getWebMember(@PathVariable String custNo) {
		WebMember webMember = new WebMember();
		webMember.setCustNo(custNo);
		
		return webMember;
	}
}
