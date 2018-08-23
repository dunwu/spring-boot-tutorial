package io.github.dunwu.springboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "io.github.dunwu.springboot")
public class FooProperties {

    private String foo;

    private String databasePlatform;

}
