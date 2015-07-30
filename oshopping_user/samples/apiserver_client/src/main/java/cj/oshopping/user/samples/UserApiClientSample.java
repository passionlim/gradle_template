package cj.oshopping.user.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserApiClientSample implements CommandLineRunner {
	@Autowired
    private RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(UserApiClientSample.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		String results = restTemplate.getForObject("http://UserService/hello", String.class);
		
		System.out.println("Hello World! from " + results);
	}
}
