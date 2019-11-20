package io.github.dunwu.springboot.msg;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Kafka生产者
 *
 * @author Zhang Peng
 * @since 2018-11-29
 */
@Component
public class SimpleKafkaDemo {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private final KafkaTemplate<String, String> kafkaTemplate;

	public SimpleKafkaDemo(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(String topic, String data) {
		log.info("向kafka发送数据:[{}]", data);
		try {
			ListenableFuture future = kafkaTemplate.send(topic, data);
			future.get();
		} catch (Exception e) {
			log.error("发送数据出错！！！{}{}", topic, data);
			log.error("发送数据出错=====>", e);
		}

		// 消息发送的监听器，用于回调返回信息
		kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
			@Override
			public void onSuccess(String topic, Integer partition, String key, String value,
				RecordMetadata recordMetadata) {
				log.info("发送数据完成");
			}

			@Override
			public void onError(String topic, Integer partition, String key, String value, Exception exception) {
				log.error("发送数据出错！！！topic = {}, partition = {}, key = {}, value = {}", topic, partition, key, value);
				log.error("发送数据出错=====>", exception);
			}
		});
	}

	@KafkaListener(id = "dunwu-kafka-consumer", topics = "${dunwu.kafka.topics}")
	public void recv(ConsumerRecord<String, String> consumerRecord) {
		log.info("收到kafka消息：{}", consumerRecord.toString());
	}

}
