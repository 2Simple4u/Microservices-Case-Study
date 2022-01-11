package com.lms.AddEmployeeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddEmployeeServiceApplication.class, args);
	}

}
