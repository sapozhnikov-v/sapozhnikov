package ru.sapozhnikov.sensorschecker.db.rest.sensor.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;
import ru.sapozhnikov.sensorschecker.db.jdbc.sensor.SensorValueRepository;

import java.util.List;

@RestController
@RequestMapping
public class SensorValueController {

    private static Logger logger = LogManager.getLogger(SensorValueController.class);

    @Autowired
    private SensorValueRepository sensorValueRepository;

    @PostMapping(value = "/sensorsvalue", consumes = "application/json")
    public void addSensorValue(@RequestBody SensorValue value) {
        logger.info("addSensorValue[{}]", value);
        sensorValueRepository.addSensorValue(value);
    }

    @GetMapping(value = "/sensorsvalue/{truckId}", produces = "application/json")
    public List<SensorValue> getSensorValueByTruckId(@PathVariable("truckId") int truckId) {
        logger.info("getSensorValueByTruckId[{}]", truckId);
        return sensorValueRepository.getSensorValueByTruckid(truckId);
    }

}