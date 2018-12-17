package io.github.dunwu.springboot;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Log4j2ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(Log4j2ApplicationTests.class);

    @Rule
    public OutputCapture output = new OutputCapture();

    @Autowired
    private MockMvc mvc;

    @Test
    public void testLogger() {
        logger.info("Hello World");
        this.output.expect(containsString("Hello World"));
    }

    @Test
    public void validateLoggersEndpoint() throws Exception {
        this.mvc.perform(get("/actuator/loggers/org.apache.coyote.http11.Http11NioProtocol")
            .header("Authorization", "Basic " + getBasicAuth())).andExpect(status().isOk()).andExpect(
            content().string(equalTo("{\"configuredLevel\":\"WARN\"," + "\"effectiveLevel\":\"WARN\"}")));
    }

    private String getBasicAuth() {
        return new String(Base64.getEncoder().encode(("user:password").getBytes()));
    }

}
