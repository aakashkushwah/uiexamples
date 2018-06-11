package com.akushwah.examples.bootse1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDSConfig implements DataSourceConfig{

	public void setup() {
		System.out.println("Setting up Dev profile data source");
	}

}
