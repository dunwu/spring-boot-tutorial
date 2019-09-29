package io.github.dunwu.springboot.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("hello")
	public String hello() {
		return "hello spring security";
	}

	@GetMapping("index")
	public Object index(Authentication authentication) {
		return authentication;
	}

}
