package com.niit.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ItemReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemReviewApplication.class, args);
	}
}
