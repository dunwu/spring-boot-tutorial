package io.github.dunwu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreBannerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(CoreBannerApplication.class);
        // springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
