package ru.sapozhnikov.sensorschecker.processing.sensor.sensor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

@Component
public class SensorValueListener {

    @Value(value = "${rest.url}/sensorsvalue")
    private String url;


    @KafkaListener(
            topics = "${kafka.topic.name}",
            containerFactory = "kafkaListenerContainerFactory")
    public void sensorsValueListener(SensorValue sensorValue) {
        System.out.println("Recieved message: " + sensorValue);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<SensorValue> request = new HttpEntity<>(sensorValue);
        SensorValue result = restTemplate.postForObject(url,request,SensorValue.class);

        }
    }
