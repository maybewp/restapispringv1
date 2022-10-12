package com.wahyu.perwira.learnrestapiv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LearnRestapiv1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LearnRestapiv1Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.source(LearnRestapiv1Application.class);
		return builder.sources(LearnRestapiv1Application.class);
	}
}
