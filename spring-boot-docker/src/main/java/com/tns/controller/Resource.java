package com.tns.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class Resource {

	@GetMapping("/hello")
	public String helloWorld() {
		return "HelloWorld";
	}
}
