package com.organize.me.organizeme;

import com.organize.me.organizeme.model.User;
import com.organize.me.organizeme.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class OrganizeMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizeMeApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService){
		return (args)-> Stream.of(new User(1L, LocalDate.now(),"username1","password1"),
				new User(2L, LocalDate.now(),"username2","password2"),
				new User(3L, LocalDate.now(),"username3","password3")).forEach(userService::create);
	}

}
