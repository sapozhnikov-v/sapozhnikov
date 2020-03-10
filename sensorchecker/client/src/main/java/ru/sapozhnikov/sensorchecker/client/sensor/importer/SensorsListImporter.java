package ru.sapozhnikov.sensorchecker.client.sensor.importer;

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

    @Value(value = "${rest.url}/sensors")
    private String url;

    public List<Sensor> getSensors() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Sensor>> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Sensor>>() {
                });
        return responseEntity.getBody();

    }
}
