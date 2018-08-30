package io.github.dunwu.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

public class SampleAopApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    private String profile;

    @Before
    public void before() {
        this.profile = System.getProperty("spring.profiles.active");
    }

    @After
    public void after() {
        if (this.profile != null) {
            System.setProperty("spring.profiles.active", this.profile);
        } else {
            System.clearProperty("spring.profiles.active");
        }
    }

    @Test
    public void testDefaultSettings() {
        BasicAopApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertThat(output).contains("Hello Zhang Peng");
    }

    @Test
    public void testCommandLineOverrides() {
        BasicAopApplication.main(new String[] {"--name=Github"});
        String output = this.outputCapture.toString();
        assertThat(output).contains("Hello Github");
    }

}
