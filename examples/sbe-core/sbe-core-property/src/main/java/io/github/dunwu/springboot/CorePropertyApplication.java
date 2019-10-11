package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;

@SpringBootApplication
public class CorePropertyApplication implements CommandLineRunner {

	private final MyProperties myProperties;

	private final ValidatorProperties validatorProperties;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomConfig.Topics topics;

	public CorePropertyApplication(MyProperties myProperties, ValidatorProperties validatorProperties) {
		this.myProperties = myProperties;
		this.validatorProperties = validatorProperties;
	}

	@Bean
	public static Validator configurationPropertiesValidator() {
		return new ValidatorPropertiesValidator();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(CorePropertyApplication.class).run(args);
	}

	@Override
	public void run(String... args) {
		log.info("validator.host: {}", validatorProperties.getHost());
		log.info("validator.port: {}", validatorProperties.getPort());
		log.info("io.github.dunwu.name: {}", myProperties.getName());
		log.info("io.github.dunwu.age: {}", myProperties.getAge());
		log.info("io.github.dunwu.sex: {}", myProperties.getSex());
		log.info("custom.topic1: {}", topics.getTopic1());
		log.info("custom.topic2: {}", topics.getTopic2());
	}

}
