package com.akushwah.examples.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulRoutingServer {


	public static void main(String[] args) {
		startZuulServiceServer(args);

	}

	/**
	 * Starts server
	 *
	 * @param args
	 *            main class' start arguments
	 * @return Application context
	 * @throws IOException
	 *             exception
	 */
	public static ApplicationContext startZuulServiceServer(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(new Object[] { ZuulRoutingServer.class }, args);

		return context;
	}

	
}