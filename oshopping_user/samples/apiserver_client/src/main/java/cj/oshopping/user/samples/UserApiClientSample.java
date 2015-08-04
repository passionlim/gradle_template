package cj.oshopping.user.samples;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

/**
 * RestTemplate 을 사용한 Sample
 * Failover 처리가 되지 않는다.
 * 
 * @author passion
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserApiClientSample implements CommandLineRunner {
	@Autowired
	@LoadBalanced
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
		//WebMember webMember = restTemplate.getForObject("http://UserService/users/{custNo}", WebMember.class, parameters); 
		while ( true ){
			String webMember = restTemplate.getForObject("http://UserService/hello/world1?message=asdf", String.class, parameters);
			System.out.println("Hello World! from " + webMember);
		}
		
		
	}
}
