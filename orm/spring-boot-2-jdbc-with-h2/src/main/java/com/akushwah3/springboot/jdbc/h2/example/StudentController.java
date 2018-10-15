package com.akushwah3.springboot.jdbc.h2.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentController {
	
	@Autowired
	StudentService service;
	
	public void doSomeOperations() {
		service.doSomeOperations();
	}
	
}
