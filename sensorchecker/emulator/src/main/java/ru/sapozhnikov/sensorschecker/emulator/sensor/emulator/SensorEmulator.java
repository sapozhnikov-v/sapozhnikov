package ru.sapozhnikov.sensorschecker.emulator.sensor.emulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.sapozhnikov.sensorschecker.core.sensor.Sensor;
import ru.sapozhnikov.sensorschecker.core.sensor.SensorValue;
import ru.sapozhnikov.sensorschecker.emulator.sensor.sensor.SensorsListImporter;

import java.util.ArrayList;
import java.util.List;

@Component
public class SensorEmulator {
    @Autowired
    private SensorsListImporter sensorsListImport;

    public List<SensorValue> sensorEmulate() {
        List<SensorValue> sensorValueList = new ArrayList<>();
        List<Sensor> sensors = sensorsListImport.getSensors();
        for (Sensor sensor : sensors) {
            sensorValueList.add(new SensorValue(null,sensor.getId(), new Randomizer().getRandomValue(sensor.getType()),null));
        }
        return sensorValueList;


    }

}
