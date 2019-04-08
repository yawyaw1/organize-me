package com.organize.me.organizeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrganizeMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizeMeApplication.class, args);
	}

}
