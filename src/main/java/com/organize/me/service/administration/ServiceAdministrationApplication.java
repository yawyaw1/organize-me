package com.organize.me.service.administration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ServiceAdministrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAdministrationApplication.class, args);
	}

}
