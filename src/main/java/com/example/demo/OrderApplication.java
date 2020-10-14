
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import org.springframework.boot.*;
// import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
// @EnableAutoConfiguration
@SpringBootApplication
public class OrderApplication {

	@RequestMapping("/order1")
	String home() {
			return "Hello order1!";
	}

	@RequestMapping("/order2")
	String home2() {
			return "Hello order2!";
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}