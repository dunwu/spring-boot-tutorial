package io.github.dunwu.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/myconfig/topic.properties")
public class CustomConfig {

    @Autowired
    Environment env;

    @Bean
    public Topics topics() {
        Topics topics = new Topics();
        topics.setTopic1(env.getProperty("custom.topic1"));
        topics.setTopic2(env.getProperty("custom.topic2"));
        return topics;
    }

    public static class Topics {
        private String topic1;
        private String topic2;

        public String getTopic1() {
            return topic1;
        }

        public void setTopic1(String topic1) {
            this.topic1 = topic1;
        }

        public String getTopic2() {
            return topic2;
        }

        public void setTopic2(String topic2) {
            this.topic2 = topic2;
        }
    }
}
