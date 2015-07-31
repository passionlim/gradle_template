package cj.oshopping.user.samples;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

import cj.oshopping.user.model.WebMember;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApiClientSample implements CommandLineRunner {
	@Autowired
    private RestTemplate restTemplate;
	
	public static void main(String[] args) {
		new SpringApplicationBuilder()
		.sources(UserApiClientSample.class)
		.web(false)
		.run(args);
//		SpringApplication.run(UserApiClientSample.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Map<String, String> parameters = Maps.newHashMap();
		parameters.put("custNo", "100001");
		
		//parameters.put("custNo", "10001");
		
		WebMember webMember = restTemplate.getForObject("http://UserService/users/{custNo}", WebMember.class, parameters); 
		
		System.out.println("Hello World! from " + webMember);
	}
}
