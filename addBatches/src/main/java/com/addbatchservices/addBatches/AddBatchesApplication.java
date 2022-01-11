package com.addbatchservices.addBatches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddBatchesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddBatchesApplication.class, args);
	}

}
