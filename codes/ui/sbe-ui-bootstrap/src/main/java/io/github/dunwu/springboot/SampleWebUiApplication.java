package io.github.dunwu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class SampleWebUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleWebUiApplication.class, args);
    }

    @Bean
    public Converter<String, Message> messageConverter() {
        return id -> messageRepository().findMessage(Long.valueOf(id));
    }

    @Bean
    public MessageRepository messageRepository() {
        return new InMemoryMessageRepository();
    }

}
