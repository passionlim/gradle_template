package cj.shopping.user.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiServerMain extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(ApiServerMain.class, args);
	}
}
