package io.github.dunwu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.dunwu.springboot.service.HelloWorldService;

@SpringBootApplication
public class BasicAopApplication implements CommandLineRunner {

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public void run(String... args) {
        System.out.println(this.helloWorldService.getHelloMessage());
        System.out.println(this.helloWorldService.makeException());
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicAopApplication.class, args);
    }

}
