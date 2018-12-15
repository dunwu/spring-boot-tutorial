package io.github.dunwu.springboot;

import io.github.dunwu.springboot.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreAopApplication implements CommandLineRunner {

    @Autowired
    private HelloWorldService helloWorldService;

    public static void main(String[] args) {
        SpringApplication.run(CoreAopApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(this.helloWorldService.getHelloMessage());

        // 放开下面的注释，会触发 io.github.dunwu.springboot.monitor.ServiceMonitor.afterThrowing
        // System.out.println(this.helloWorldService.makeException(null));
    }

}
