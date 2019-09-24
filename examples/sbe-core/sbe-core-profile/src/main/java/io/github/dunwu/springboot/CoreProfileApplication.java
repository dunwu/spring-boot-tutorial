package io.github.dunwu.springboot;

import io.github.dunwu.springboot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreProfileApplication implements CommandLineRunner {

	@Autowired
	private MessageService helloWorldService;

	public static void main(String[] args) {
		SpringApplication.run(CoreProfileApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getMessage());
	}

}
