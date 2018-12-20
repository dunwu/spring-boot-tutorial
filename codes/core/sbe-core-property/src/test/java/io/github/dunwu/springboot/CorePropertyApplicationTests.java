package io.github.dunwu.springboot;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CorePropertyApplicationTests {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    @After
    public void closeContext() {
        this.context.close();
    }

    @Test
    public void bindValidProperties() {
        this.context.register(CorePropertyApplication.class);
        TestPropertyValues.of("validator.host:127.0.0.1", "validator.port:9090").applyTo(this.context);
        this.context.refresh();
        ValidatorProperties properties = this.context.getBean(ValidatorProperties.class);
        assertThat(properties.getHost()).isEqualTo("127.0.0.1");
        assertThat(properties.getPort()).isEqualTo(Integer.valueOf(9090));
    }

    @Test
    public void bindInvalidHost() {
        this.context.register(CorePropertyApplication.class);
        TestPropertyValues.of("validator.host:xxxxxx", "validator.port:9090").applyTo(this.context);
        assertThatExceptionOfType(BeanCreationException.class).isThrownBy(() -> this.context.refresh())
                                                              .withMessageContaining(
                                                                  "Failed to bind properties under 'validator'");
    }

    @Test
    public void bindNullHost() {
        this.context.register(CorePropertyApplication.class);
        assertThatExceptionOfType(BeanCreationException.class).isThrownBy(() -> this.context.refresh())
                                                              .withMessageContaining(
                                                                  "Failed to bind properties under 'validator'");
    }
}
