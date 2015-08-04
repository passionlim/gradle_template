package cj.oshopping.user.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("cj.oshopping.user.api")
@ConfigurationProperties(locations="classpath:api/userService.yml")
public class UserApiConfiguration {

	//
	//UserService:
//		  ribbon:
//		    read-timeout: 3000  
//		    connect-timeout: 3000
//		    ServerListRefreshInterval: 1000
//		    MaxAutoRetries: 1
//		    MaxAutoRetriesNextServer: 3 
//		    OkToRetryOnAllOperations: true

//	@ConfigurationProperties(prefix="UserService")
//	class UserApiProperties {
//		private 
//	}
}
