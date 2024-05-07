package com.cybage.onlinefoodapp;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.cybage")
@EnableJpaRepositories(basePackages = "com.cybage.dao")
@EntityScan(basePackages = "com.cybage.model")
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class OnlineFoodAppApplication {

	static Logger logger=Logger.getLogger(OnlineFoodAppApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodAppApplication.class, args);
     logger.setLevel(Level.INFO);
     
     
     
	
	}

}
