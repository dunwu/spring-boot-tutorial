/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package io.github.dunwu.springboot;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationLog4J2ApplicationTests {

    private static final Logger logger =
            LoggerFactory.getLogger(IntegrationLog4J2ApplicationTests.class);

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
                .header("Authorization", "Basic " + getBasicAuth())).andExpect(status().isOk())
                .andExpect(content().string(equalTo(
                        "{\"configuredLevel\":\"WARN\"," + "\"effectiveLevel\":\"WARN\"}")));
    }

    private String getBasicAuth() {
        return new String(Base64.getEncoder().encode(("user:password").getBytes()));
    }

}
