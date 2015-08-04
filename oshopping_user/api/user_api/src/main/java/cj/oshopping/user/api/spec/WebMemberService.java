package cj.oshopping.user.api.spec;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cj.oshopping.user.model.WebMember;

@FeignClient("UserService")
@RequestMapping("/webMember")
public interface WebMemberService {
	
	@RequestMapping(value="/{custNo}", method=RequestMethod.GET)
	public WebMember getWebMember(@PathVariable("custNo") String custNo);
}
