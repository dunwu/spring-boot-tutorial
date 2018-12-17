package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Log4j2Application {

    private static final Logger logger = LoggerFactory.getLogger(Log4j2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

    @PostConstruct
    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }
}
