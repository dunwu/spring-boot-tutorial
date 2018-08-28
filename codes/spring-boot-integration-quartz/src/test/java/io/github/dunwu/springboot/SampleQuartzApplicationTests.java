package io.github.dunwu.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.ConfigurableApplicationContext;

public class SampleQuartzApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void quartzJobIsTriggered() throws InterruptedException {
        try (ConfigurableApplicationContext context =
                SpringApplication.run(SampleQuartzApplication.class)) {
            long end = System.currentTimeMillis() + 5000;
            while ((!this.outputCapture.toString().contains("Hello World!"))
                    && System.currentTimeMillis() < end) {
                Thread.sleep(100);
            }
            assertThat(this.outputCapture.toString()).contains("Hello World!");
        }
    }

}
