package io.github.dunwu.springboot.kafka;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * Kafka生产者
 * @author Zhang Peng
 * @date 2018-11-29
 */
@Component
public class KafkaProducer {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, String data) {
        LOGGER.info("向kafka发送数据:[{}]", data);
        try {
           kafkaTemplate.send(topic, data);
        } catch (Exception e) {
            LOGGER.error("发送数据出错！！！{}{}", topic, data);
            LOGGER.error("发送数据出错=====>", e);
        }

        //消息发送的监听器，用于回调返回信息
        kafkaTemplate.setProducerListener(new ProducerListener<String, String>() {
            @Override
            public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
                LOGGER.info("发送数据完成");
            }

            @Override
            public void onError(String topic, Integer partition, String key, String value, Exception exception) {
                LOGGER.error("发送数据出错！！！{}{}", topic);
                LOGGER.error("发送数据出错=====>", exception);
            }
        });
    }
}
