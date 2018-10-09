package com.akushwah3.springboot.jdbc.h2.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

	@Autowired
	StudentController controller;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		controller.doSomeOperations();
	}
}
