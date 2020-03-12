package ru.sapozhnikov.sensorschecker.emulator.sensor.emulator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;
import ru.sapozhnikov.sensorschecker.emulator.sensor.sensor.SensorsListImporter;

import java.util.ArrayList;
import java.util.List;

@Component
public class SensorEmulator {

    private static final Logger logger = LogManager.getLogger(SensorEmulator.class);

    @Autowired
    private SensorsListImporter sensorsListImport;

    public List<SensorValue> sensorEmulate() {
        logger.info("sensorEmulate[]");
        List<SensorValue> sensorValueList = new ArrayList<>();
        List<Sensor> sensors = sensorsListImport.getSensors();
        for (Sensor sensor : sensors) {
            new Randomizer();
            sensorValueList.add(new SensorValue(null, sensor.getId(), Randomizer.getRandomValue(sensor.getType()), null));
        }
        return sensorValueList;
    }

}
