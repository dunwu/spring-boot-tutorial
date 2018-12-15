package io.github.dunwu.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LogbackApplication {

    private static final Logger logger = LoggerFactory.getLogger(LogbackApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args).close();
    }

    @PostConstruct
    public void logSomething() {
        logger.trace("Sample Trace Message");
        logger.debug("Sample Debug Message");
        logger.info("Sample Info Message");
        logger.warn("Sample Warn Message");
        logger.error("Sample Error Message");
    }
}
