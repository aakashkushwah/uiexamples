package com.akushwah.examples.bootse1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@Autowired
	ProfileManager manager;
	
	@Autowired
	DataSourceConfig dsConfig;
	
	@Value("${sample.location}")
	String location;
	
	
	@Autowired
	ConfigProperties props;

	@GetMapping("/")
	String Hello(){
		manager.getActiveProfiles();
		dsConfig.setup();
		System.out.println(location);
		System.out.println(props.getCredentials().getAuthMethod());
		return "Hello World";
	}
}
