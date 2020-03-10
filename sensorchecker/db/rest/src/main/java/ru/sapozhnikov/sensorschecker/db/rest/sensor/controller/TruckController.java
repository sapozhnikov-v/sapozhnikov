package ru.sapozhnikov.sensorschecker.db.rest.sensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sapozhnikov.sensorschecker.core.sensor.Truck;
import ru.sapozhnikov.sensorschecker.db.jdbc.sensor.TruckRepository;

import java.util.List;

@RestController
@RequestMapping
public class TruckController {

    @Autowired
    private TruckRepository tR;

    @GetMapping(value = "/trucks", produces = "application/json")
    public List<Truck> getAllTrucks() {
        return tR.getAllTrucks();
    }

    @PostMapping(value = "/truckadd", consumes = "application/json")
    public void addTruck(@RequestBody Truck truck) {
        tR.addTruck(truck);

    }
}
