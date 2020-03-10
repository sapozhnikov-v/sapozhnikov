package ru.sapozhnikov.sensorchecker.client.sensor.importer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

import java.util.List;

@Component
public class TruckListImporter {

    @Value(value = "${rest.url}/trucks")
    private String url;

    public List<Truck> getTrucks() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Truck>> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Truck>>() {
                });
        return responseEntity.getBody();

    }
}


