package com.akushwah.examples.bootse1;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdDSConfig implements DataSourceConfig{

	public void setup() {
		System.out.println("Setting up prod profile data source");
	}

}
