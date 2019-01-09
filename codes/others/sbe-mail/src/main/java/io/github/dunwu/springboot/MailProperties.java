package io.github.dunwu.springboot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author Zhang Peng
 * @date 2019-01-09
 */
@Data
@Validated
@Component
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    private String domain;
    private String from;
}
