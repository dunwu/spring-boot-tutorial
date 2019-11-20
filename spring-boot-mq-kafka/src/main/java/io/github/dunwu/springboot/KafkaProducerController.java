package io.github.dunwu.springboot;

import io.github.dunwu.springboot.msg.SimpleKafkaDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring-boot kafka 示例
 * <p>
 * 此 Controller 作为生产者，接受REST接口传入的消息，并写入到指定 Kafka Topic
 * <p>
 * 访问方式：http://localhost:8080/kafka/send?topic=xxx&data=xxx
 *
 * @author Zhang Peng
 */
@RestController
@RequestMapping("kafka")
public class KafkaProducerController {

	private final SimpleKafkaDemo simpleKafkaDemo;

	public KafkaProducerController(SimpleKafkaDemo simpleKafkaDemo) {
		this.simpleKafkaDemo = simpleKafkaDemo;
	}

	@RequestMapping("send")
	public void send(String topic, String data) {
		simpleKafkaDemo.send(topic, data);
	}

}
