package io.github.dunwu.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @see io.github.dunwu.springboot.monitor.ServiceMonitor
 */
@Component
public class HelloWorldService {

    public static final String EXPECT_EXCEPTION_MSG = "Get a exception";

    @Value("${author.name:Unknow}")
    private String name;

    @Value("${throw.exception:false}")
    private boolean throwException;

    public String getHelloMessage() {
        return "Hello " + this.name;
    }

    public void getException() throws Exception {
        if (throwException) {
            throw new Exception(EXPECT_EXCEPTION_MSG);
        }
    }
}
