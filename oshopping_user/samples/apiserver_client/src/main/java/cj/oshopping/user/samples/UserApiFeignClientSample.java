package cj.oshopping.user.samples;

import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.Import;

import com.google.common.collect.Maps;

import cj.oshopping.user.api.UserApiConfiguration;
import cj.oshopping.user.api.spec.HelloWorld;
import cj.oshopping.user.api.spec.WebMemberService;
import cj.oshopping.user.model.WebMember;

/**
 * Feign 을 사용한 Sample
 * 
 * @author passion
 *
 */
@SpringBootApplication
@Import(value = { UserApiConfiguration.class })
public class UserApiFeignClientSample implements CommandLineRunner {
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	HelloWorld helloWorld;

	@Autowired
	WebMemberService webMemberService;

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(UserApiFeignClientSample.class).web(false).run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Map<String, String> parameters = Maps.newHashMap();
		parameters.put("custNo", "100001");
		int failCount = 0;
		while (true) {
			try {
				WebMember webMember = webMemberService.getWebMember("1000001");
				System.out.println("Hello World! from " + ToStringBuilder.reflectionToString(webMember));
			} catch (Exception e) {
				failCount++;
				LOGGER.error(e.getMessage(), e);
			}
			if (failCount > 10) {
				System.out.println("failCount: " + failCount);
				break;
			}
		}
	}
}
