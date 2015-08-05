package cj.oshopping.user.api.spec;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cj.oshopping.user.api.UserApiService;
import cj.oshopping.user.model.WebMember;

@UserApiService
@RequestMapping("/webMember")
public interface WebMemberService {
	
	@RequestMapping(value="/{custNo}", method=RequestMethod.GET)
	public WebMember getWebMember(@PathVariable("custNo") String custNo);
}
