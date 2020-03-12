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
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;

import java.util.List;

@Component
public class TruckListComponent {

    private static final Logger logger = LogManager.getLogger(TruckListComponent.class);

    @Value(value = "${rest.url}/trucks")
    private String urlGetTrucks;

    @Value(value = "${rest.url}/truckadd")
    private String urlAddTruck;

    public List<Truck> getTrucks() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Truck>> responseEntity = restTemplate.exchange(urlGetTrucks,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Truck>>() {
                });
        return responseEntity.getBody();
    }

    public void createTruck(Truck truck) {
        logger.info("createTruck[{}]", truck);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Truck> request = new HttpEntity<>(truck);
        restTemplate.postForObject(urlAddTruck, request, Truck.class);
    }

}


