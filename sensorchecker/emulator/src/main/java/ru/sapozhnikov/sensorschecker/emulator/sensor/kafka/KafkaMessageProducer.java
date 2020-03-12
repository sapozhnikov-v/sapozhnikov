package ru.sapozhnikov.sensorschecker.emulator.sensor.kafka;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

@Component
public class KafkaMessageProducer {

    private static final Logger logger = LogManager.getLogger(KafkaMessageProducer.class);

    @Value(value = "${kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, SensorValue> kafkaTemplate;

    public void sendMessage(SensorValue sensorValue) {
        logger.info("sendMessage[{}]", sensorValue);
        kafkaTemplate.send(topicName, sensorValue);
    }

}
