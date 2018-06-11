package com.akushwah.examples.c2;

import org.springframework.stereotype.Component;

import com.akushwah.examples.c1.MyService;

@Component
public class MyServiceImpl1 implements MyService{

	public void serveTheLord(String msg) {
		System.out.println("Impl1 in c2 "+msg);
	}

}
