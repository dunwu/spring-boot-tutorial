package io.github.dunwu.springboot;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
public class WebUISwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebUISwaggerApplication.class, args);
    }

}
