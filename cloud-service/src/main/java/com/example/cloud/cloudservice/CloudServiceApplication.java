package com.example.cloud.cloudservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CloudServiceApplication {

	//要制定spring.profiles.active
	@Value("${b1.b2.b3}")
	private String bbb;

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceApplication.class, args);
	}

	@GetMapping("/")
	public String welcome() {
		return bbb;
	}
}
