package io.github.dunwu.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHelloWorldController {

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}

}
