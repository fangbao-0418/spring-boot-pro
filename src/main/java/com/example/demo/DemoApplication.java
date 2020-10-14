package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.restdocs.*;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 import org.springframework.restdocs.restassured3;
 import org.springframework.boot.*;
 import org.springframework.boot.autoconfigure.*;
*/
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
// @RestAssuredRestDocumentationConfigurer
// @EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

	// private RequestSpecification spec;

	// @Before
	// public void setUp() {
	// 	// this.spec = new RequestSpecBuilder().addFilter(
	// 	// 		documentationConfiguration(this.restDocumentation)) 
	// 	// 		.build();
	// }
	private static final String template = "Hello, %s!";
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(1, String.format(template, name));
	}

	@RequestMapping(value = "/upload", method = POST)
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/home2")
	Greeting home2() {
		return new Greeting(1, "jiao ba ba");
		// return "Hello home2!";
	}

	// @RestAssuredRestDocumentation
	// public static void documentationConfiguration() {

	// }
	// public static void main(String[] args) {
	// 	// SpringApplication.run(DemoApplication.class, args);
	// }

}
