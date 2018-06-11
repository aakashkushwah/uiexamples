/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akushwah.examples.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akushwah.examples.c1.MyService;

@RestController
@Component
public class HelloWorldController {

	@Value("${server.port}")
	private String value;
	
	@Autowired
	private MyService myService;
	
	@GetMapping("/hellozoosd")
	public String HelloWorld() {
		return "Hello World via zookeeper-sd! "+value;
	}
	
	@GetMapping("/hellozoosd2")
	public String HelloWorld2() {
		myService.serveTheLord("Aakash");
		return "Hello World via zookeeper-sd!";
	}

}
