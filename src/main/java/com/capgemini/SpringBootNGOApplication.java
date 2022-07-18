package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class SpringBootNGOApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootNGOApplication.class, args);
	}
}
