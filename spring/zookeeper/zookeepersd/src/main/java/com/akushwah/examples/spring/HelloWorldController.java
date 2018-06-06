/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akushwah.examples.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Value("${server.port}")
	private String value;
	
	@GetMapping("/hellozoosd")
	public String HelloWorld() {
		return "Hello World via zookeeper-sd! "+value;
	}

}
