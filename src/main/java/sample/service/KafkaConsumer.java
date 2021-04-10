package sample.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(groupId = "test", topics = {"sample"})
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaHandler(isDefault = true)
    public void consume(ConsumerRecord<?, ?> record) {
        LOGGER.info("headers: {}, key: {}, value: {}", record.headers(), record.key(), record.value());
    }
}
