package com.inti;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan
public class AmazingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazingProjectApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getpce() {
		return new BCryptPasswordEncoder();
	}
	
	@RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
}
