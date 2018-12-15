package io.github.dunwu.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @see io.github.dunwu.springboot.monitor.ServiceMonitor
 */
@Component
public class HelloWorldService {

    @Value("${name:World}")
    private String name;

    public String getHelloMessage() {
        return "Hello " + this.name;
    }

    public String makeException(String str) {
        return str.toLowerCase();
    }
}
