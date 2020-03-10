package ru.sapozhnikov.sensorschecker.emulator.sensor.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

@Component
public class KafkaMessageProducer {

    @Value(value = "${kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, SensorValue> kafkaTemplate;



    public void sendMessage(SensorValue sensorValue) {
        kafkaTemplate.send(topicName, sensorValue);
    }
}
