package cj.oshopping.user.service;

import org.springframework.stereotype.Service;

import cj.oshopping.user.model.WebMember;

@Service
public class WebMemberService {
	
	public WebMember getWebMember(String custNo) {
		WebMember webMember = new WebMember();
		webMember.setCustNo(custNo);
		
		return webMember;
	}
}
