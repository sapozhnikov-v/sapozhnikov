package ru.sapozhnikov.sensorschecker.emulator.sensor.sensor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;

import java.util.List;

@Component
public class SensorsListImporter {

    private static final Logger logger = LogManager.getLogger(SensorsListImporter.class);

    @Value(value = "${rest.url}/sensors")
    private String url;

    public List<Sensor> getSensors() {
        logger.info("getSensors[]");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Sensor>> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Sensor>>() {
                });
        return responseEntity.getBody();
    }

}
