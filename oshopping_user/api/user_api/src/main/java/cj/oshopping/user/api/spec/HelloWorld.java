package cj.oshopping.user.api.spec;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cj.oshopping.user.api.UserApiService;

@UserApiService
@RequestMapping("/hello")
public interface HelloWorld {
    @RequestMapping(value="/world1", method=RequestMethod.GET)
	String helloWorld(@RequestParam("message") String message);

    @RequestMapping(value="/world2", method=RequestMethod.GET)
	String helloWorld2(@RequestParam("message") String message);

}