package com.springboot.springbootfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringbootFeignclientMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFeignclientMicroservicesApplication.class, args);
	}

}
