package com.akushwah.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//CHECKSTYLE:OFF
@SpringBootApplication
@EnableAutoConfiguration
public class SampleAmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleAmqApplication.class, args);
    }
}
