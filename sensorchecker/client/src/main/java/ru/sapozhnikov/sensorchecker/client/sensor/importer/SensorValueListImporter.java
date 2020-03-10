package ru.sapozhnikov.sensorchecker.client.sensor.importer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;

import java.util.List;

@Component
public class SensorValueListImporter {

    @Value(value = "${rest.url}/sensorsvalue/")
    private String url;

    public List<SensorValue> getSensorValueByTruckId(int truckId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<SensorValue>> responseEntity = restTemplate.exchange(url + truckId,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<SensorValue>>() {
                });
        return responseEntity.getBody();

    }

}
