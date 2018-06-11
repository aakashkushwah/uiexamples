package com.javacodegeeks.camel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelActivemqExampleUsingSpring {
	public static final void main(String[] args) throws Exception {
//		ApplicationContext appContext = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		CamelContext camelContext = SpringCamelContext.springCamelContext(
//				appContext, false);
//		try {
//			camelContext.start();
//			Thread.sleep(2000);
//		} finally {
//			camelContext.stop();
//		}
//		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Keep main thread alive for some time to let application finish processing the input files.
        Thread.sleep(10000);
        applicationContext.close();
	}
}
