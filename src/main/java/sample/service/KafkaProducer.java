package sample.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> template;

    public KafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Scheduled(initialDelay = 2000, fixedRate = 1000)
    public void produce() throws ExecutionException, InterruptedException, TimeoutException {
        var sample = new ProducerRecord<>("sample", UUID.randomUUID().toString(), UUID.randomUUID().toString());
        var result = template.send(sample);
        LOGGER.info("result: {}", result.get(1000, TimeUnit.MILLISECONDS).getRecordMetadata().offset());
    }
}
