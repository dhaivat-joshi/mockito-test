package com.spring.junit.unitTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hello-world")
	public String hello() {
		return "hello-world";
	}

}
