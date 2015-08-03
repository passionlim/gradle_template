package cj.oshopping.user.samples;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Maps;

import cj.shopping.user.api.HelloWorld;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages={"cj.oshopping.user"})
public class UserApiFeignClientSample implements CommandLineRunner {
	
	@Autowired
	HelloWorld helloWorld;
	
	public static void main(String[] args) {
		new SpringApplicationBuilder()
		.sources(UserApiFeignClientSample.class)
		.web(false)
		.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Map<String, String> parameters = Maps.newHashMap();
		parameters.put("custNo", "100001");
		while ( true ){
			String webMember = helloWorld.helloWorld("test message");
			System.out.println("Hello World! from " + webMember);
		}
	}
	
	@FeignClient("UserService")
	public interface HelloWorld {
	    @RequestMapping(method = RequestMethod.GET, value = "/hello")
		String helloWorld(@RequestParam("message") String message);
	}
}
