package com.telkom.salesportal.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SalesPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesPortalApplication.class, args);
	}

}
