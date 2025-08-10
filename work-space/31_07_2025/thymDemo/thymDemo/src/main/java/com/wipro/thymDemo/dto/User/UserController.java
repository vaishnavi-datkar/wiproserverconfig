package com.wipro.thymDemo.dto.User;

import org.springframework.web.bind.annotation.RestController;

@
RequestNapping("/user")

public class UserController {
	@PostMapping
	void Save(@RequestBody User user) {
		System.pout.pritnln("-post-");
		System.out.println(user);
		
	}
	@PutMapping
	void update(@RequestBody User user)
	{

}
