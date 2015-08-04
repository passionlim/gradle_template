package cj.shopping.user.apiserver.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cj.oshopping.user.api.spec.WebMemberService;
import cj.oshopping.user.model.WebMember;

@RestController
public class WebMemberController implements WebMemberService {
	
	public WebMember getWebMember(@PathVariable String custNo) {
		WebMember webMember = new WebMember();
		webMember.setCustNo(custNo);
		
		return webMember;
	}
}
