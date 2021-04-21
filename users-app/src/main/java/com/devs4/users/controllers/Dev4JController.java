package com.devs4.users.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Dev4JController {

	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}
}
