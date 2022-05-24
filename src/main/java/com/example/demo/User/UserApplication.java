package com.example.demo.User;

import org.springframework.web.bind.annotation.*;

@RestController
// @SpringBootApplication
public class UserApplication {
	// private UserRepository userRepository;
	@PostMapping(path="/api/create/user")
	CreateUserVO createUser(@RequestBody CreateUserVO data) {
		System.out.print("xxxx");
		System.out.println(data.name);
		return data;
	}
}
