package io.github.dunwu.springboot;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

public class IntegrationLogbackApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testLoadedCustomLogbackConfig() {
        IntegrationLogbackApplication.main(new String[0]);
        this.outputCapture.expect(containsString("Sample Debug Message"));
        this.outputCapture.expect(not(containsString("Sample Trace Message")));
    }

    @Test
    public void testProfile() {
        IntegrationLogbackApplication.main(new String[] {"--spring.profiles.active=staging"});
        this.outputCapture.expect(containsString("Sample Debug Message"));
        this.outputCapture.expect(containsString("Sample Trace Message"));
    }

}
