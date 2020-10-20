
package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class OrderApplication {

	@RequestMapping("/order1")
	String home() {
			return "Hello order1!";
	}

	@RequestMapping("/order2")
	String home2() {
			return "Hello order2!";
	}

}