package ru.sapozhnikov.sensorschecker.processing.sensor.sensor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

@Component
public class SensorValueListener {

    private static final Logger logger = LogManager.getLogger(SensorValueListener.class);

    @Value(value = "${rest.url}/sensorsvalue")
    private String url;

    @KafkaListener(
            topics = "${kafka.topic.name}",
            containerFactory = "kafkaListenerContainerFactory")

    public void sensorValueListener(SensorValue sensorValue) {
        logger.info("sensorValueListener[{}]", sensorValue);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<SensorValue> request = new HttpEntity<>(sensorValue);
        restTemplate.postForObject(url, request, SensorValue.class);
    }

}
