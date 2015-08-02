package cj.oshopping.infra.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
public class SpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServerApplication.class, args);
	}

}