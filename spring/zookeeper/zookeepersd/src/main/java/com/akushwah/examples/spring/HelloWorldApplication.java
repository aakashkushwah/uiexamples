package com.akushwah.examples.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.akushwah.examples.c1", "com.akushwah.examples.c3", "com.akushwah.examples.spring"})
public class HelloWorldApplication {

	public static void main(String[] args) {
		  SpringApplication.run(HelloWorldApplication.class, args);
	}

}
