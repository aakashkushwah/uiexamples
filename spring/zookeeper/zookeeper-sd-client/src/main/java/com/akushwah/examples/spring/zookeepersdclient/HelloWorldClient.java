package com.akushwah.examples.spring.zookeepersdclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class provides operations on the Validation service.
 *
 * <p>
 * When booting up, Spring will try and find a service named "Validation" (see
 * the FeignClient below) under the available ZooKeeper instance.
 * </p>
 *
 */
@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class HelloWorldClient {

	@Autowired
	private TheClient theClient;

	@FeignClient(name = "zookeepersd")
	interface TheClient {

		@RequestMapping(path = "/hellozoosd", method = RequestMethod.GET)
		@ResponseBody
		String HelloWorld();
	}
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public String serviceUrl() {
	    List<ServiceInstance> list = discoveryClient.getInstances("zookeepersd");
	    if (list != null && list.size() > 0 ) {
	        return list.get(0).getUri().toString();
	    }
	    return null;
	}

	public String HelloWorld() {
		return serviceUrl()+" Test "+theClient.HelloWorld();
	}

}
