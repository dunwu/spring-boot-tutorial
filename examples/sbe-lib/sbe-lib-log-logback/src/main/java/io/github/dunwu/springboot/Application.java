package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void logInAllLevel() {
		log.error("Print Error Message");
		log.warn("Print Warn Message");
		log.info("Print Info Message");
		log.debug("Print Debug Message");
		log.trace("Print Trace Message");
	}

}
