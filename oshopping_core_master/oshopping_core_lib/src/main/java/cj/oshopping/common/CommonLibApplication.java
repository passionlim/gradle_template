package cj.oshopping.common;

import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonLibApplication {
	static Pattern cjmallPattern = Pattern.compile("https?:\\/\\/[^.]*\\.cjmall\\.com(\\/.*)?");
	
    public static void main(String[] args) {
    	System.out.println(cjmallPattern.matcher("https://md.cjmall.com/m/login/id_find.jsp?app_cd=PDA").matches());
        //SpringApplication.run(CommonLibApplication.class, args);
    }
}
