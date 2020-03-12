package ru.sapozhnikov.sensorschecker.client.sensor.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;

import java.util.List;

@Component
public class SensorsListComponent {

    private static final Logger logger = LogManager.getLogger(SensorsListComponent.class);

    @Value(value = "${rest.url}/sensors")
    private String urlGetSensors;

    @Value(value = "${rest.url}/sensoradd")
    private String urlAddSensor;

    public List<Sensor> getSensors() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Sensor>> responseEntity = restTemplate.exchange(urlGetSensors,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Sensor>>() {
                });
        return responseEntity.getBody();
    }

    public void createSensor(Sensor sensor) {
        logger.info("createSensor[{}]", sensor);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Sensor> request = new HttpEntity<>(sensor);
        restTemplate.postForObject(urlAddSensor, request, Sensor.class);
    }

}
