package io.github.dunwu.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2019-09-24
 */
@RestController
public class HelloController {

	@GetMapping({ "/", "hello" })
	public String hello() {
		return "Hello World!";
	}

}
