package com.service.disroauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class  DisroAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisroAuthServiceApplication.class, args);
    }

}
