package io.github.dunwu.springboot.kafka;

import io.github.dunwu.springboot.KafkaDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Zhang Peng
 * @date 2018-11-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaDemoApplication.class)
public class KafkaTest {
    @Autowired
    private KafkaProducer kafkaProducer;

    @Test
    public void test() {
        kafkaProducer.send("test", "上联：天王盖地虎");
        kafkaProducer.send("test", "下联：宝塔镇河妖");
    }
}
