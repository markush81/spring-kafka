package sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by markus on 14/05/16.
 */
@SpringBootApplication
@EnableScheduling
@EnableKafka
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.info("JVM Info");
        LOGGER.info("\tavailableProcessors; {}", Runtime.getRuntime().availableProcessors());
        LOGGER.info("\tmaxMemory; {}", Runtime.getRuntime().maxMemory());
        LOGGER.info("\tmaxMemory; {}", Runtime.getRuntime().maxMemory());
        LOGGER.info("\ttotalMemory; {}", Runtime.getRuntime().totalMemory());

        SpringApplication.run(Application.class, args);
    }
}
