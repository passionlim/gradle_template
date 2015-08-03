package cj.shopping.user.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("UserService")
public interface HelloWorld {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
	String helloWorld(String message);
}
