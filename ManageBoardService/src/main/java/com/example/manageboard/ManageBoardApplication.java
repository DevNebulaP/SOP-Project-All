package com.example.manageboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ManageBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageBoardApplication.class, args);
	}

}
