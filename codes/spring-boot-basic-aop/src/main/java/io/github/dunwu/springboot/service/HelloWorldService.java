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

    // 放开下面方法的注释，会触发 io.github.dunwu.springboot.monitor.ServiceMonitor.afterThrowing
    // public String makeException() {
    // String str = null;
    // return str.toLowerCase();
    // }
}
