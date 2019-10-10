package io.github.dunwu.springboot.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TestController {

	@ResponseBody
	@GetMapping("hello")
	public String hello() {
		return "hello spring security";
	}

	@GetMapping(value = { "/", "index" })
	public ModelAndView index(Map<String, Object> model, Authentication authentication) {
		return new ModelAndView("index", "messages", authentication);
	}

}
