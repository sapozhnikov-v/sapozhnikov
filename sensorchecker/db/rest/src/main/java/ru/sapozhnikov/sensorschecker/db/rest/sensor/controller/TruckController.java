package ru.sapozhnikov.sensorschecker.db.rest.sensor.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;
import ru.sapozhnikov.sensorschecker.db.jdbc.sensor.TruckRepository;

import java.util.List;

@RestController
@RequestMapping
public class TruckController {

    private static final Logger logger = LogManager.getLogger(TruckController.class);

    @Autowired
    private TruckRepository truckRepository;

    @GetMapping(value = "/trucks", produces = "application/json")
    public List<Truck> getAllTrucks() {
        logger.info("getAllTrucks");
        return truckRepository.getAllTrucks();
    }

    @PostMapping(value = "/truckadd", consumes = "application/json")
    public void addTruck(@RequestBody Truck truck) {
        logger.info("addTruck[{}]", truck);
        truckRepository.addTruck(truck);
    }

}
