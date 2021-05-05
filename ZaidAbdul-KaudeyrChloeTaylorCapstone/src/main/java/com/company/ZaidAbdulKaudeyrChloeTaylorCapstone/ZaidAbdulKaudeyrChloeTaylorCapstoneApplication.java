package com.company.ZaidAbdulKaudeyrChloeTaylorCapstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class ZaidAbdulKaudeyrChloeTaylorCapstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaidAbdulKaudeyrChloeTaylorCapstoneApplication.class, args);
	}

}
