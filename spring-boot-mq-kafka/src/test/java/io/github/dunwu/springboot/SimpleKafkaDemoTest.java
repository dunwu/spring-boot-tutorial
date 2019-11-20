package io.github.dunwu.springboot;

import io.github.dunwu.springboot.msg.SimpleKafkaDemo;
import io.github.dunwu.util.collection.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Zhang Peng
 * @since 2018-11-29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMsgKafkaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleKafkaDemoTest {

	@Value("${dunwu.kafka.topics}")
	private List<String> topics;

	@Autowired
	private SimpleKafkaDemo simpleKafkaDemo;

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void test() {
		simpleKafkaDemo.send(randomInArray(topics), "上联：天王盖地虎");
		simpleKafkaDemo.send(randomInArray(topics), "下联：宝塔镇河妖");
	}

	public static <T> T randomInArray(List<T> list) {
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		int index = RandomUtils.nextInt(0, list.size());
		return list.get(index);
	}

}
