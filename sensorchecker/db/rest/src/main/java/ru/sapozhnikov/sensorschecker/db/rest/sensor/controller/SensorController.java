package ru.sapozhnikov.sensorschecker.db.rest.sensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.db.jdbc.sensor.SensorRepository;

import java.util.List;

@RestController
@RequestMapping
public class SensorController {

    @Autowired
    private SensorRepository sr;

    @GetMapping(value = "/sensors", produces = "application/json")
    public List<Sensor> getAllSensors() {
        return sr.getAllSensors();
    }
}
