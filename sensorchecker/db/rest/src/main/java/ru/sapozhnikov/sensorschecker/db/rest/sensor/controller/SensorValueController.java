package ru.sapozhnikov.sensorschecker.db.rest.sensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;
import ru.sapozhnikov.sensorschecker.db.jdbc.sensor.SensorValueRepository;

@RestController
@RequestMapping
public class SensorValueController {

    @Autowired
    private SensorValueRepository srv;

    @PostMapping(value = "/sensorsvalue", consumes = "application/json")
    public void addSensorValue(@RequestBody SensorValue value) {
        srv.addSensorValue(value);

    }
}