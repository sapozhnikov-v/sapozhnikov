package ru.sapozhnikov.sensorschecker.db.rest.sensor.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.db.jdbc.sensor.SensorRepository;

import java.util.List;

@RestController
@RequestMapping
public class SensorController {

    private static final Logger logger = LogManager.getLogger(SensorController.class);

    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping(value = "/sensors", produces = "application/json")
    public List<Sensor> getAllSensors() {
        logger.info("getAllSensors[]");
        return sensorRepository.getAllSensors();
    }

    @PostMapping(value = "/sensoradd", consumes = "application/json")
    public void addSensor(@RequestBody Sensor sensor) {
        logger.info("addSensor[{}]", sensor);
        sensorRepository.addSensor(sensor);
    }

}
