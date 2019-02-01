package com.markos.jpa;

import com.markos.jpa.service.MaterialService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
//@Configuration
//@EnableJpaRepositories
//@EnableAutoConfiguration
//@EnableWebMvc
//@ComponentScan({
//		"com.markos.jpa.controller",
//		"com.markos.jpa.repository",
//		"com.markos.jpa.service"
//})
public class CriteriaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CriteriaDemoApplication.class, args);
	}

}

