package com.akushwah.examples.bootse1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class MyRestController {
	@RequestMapping(value = "/{user}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long user) {
		User user1 = new User();
		user1.setName("Aakash");
		user1.setUrl("Joker "+user);
		System.out.println(user1);
		return user1;
	}

	
}
