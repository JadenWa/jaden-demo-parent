package com.jaden;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yawn
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ActivitiDemo6SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiDemo6SpringbootApplication.class, args);
	}
}
