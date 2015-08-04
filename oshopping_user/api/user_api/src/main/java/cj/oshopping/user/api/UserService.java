package cj.oshopping.user.api;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("UserService")
public interface UserService {
}
