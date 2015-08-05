package cj.oshopping.user.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import feign.Request;

@Configuration
@EnableDiscoveryClient
@EnableFeignClients("cj.oshopping.user.api")
@PropertySource("classpath:api/userService.properties")
public class UserApiConfiguration {

	@Value("${UserService.ribbon.ConnectTimeout}")
	Integer connectTimeout = 10 * 1000;

	@Value("${UserService.ribbon.ReadTimeout}")
	Integer readTimeout = 60 * 1000;

	@Bean
	public Request.Options userApiTimeoutConfiguration() {
		return new Request.Options(connectTimeout, readTimeout);
	}
}
