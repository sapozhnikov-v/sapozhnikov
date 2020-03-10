package ru.sapozhnikov.sensorschecker.emulator.sensor.emulator;

import ru.sapozhnikov.sensorschecker.core.sensor.SensorType;

import java.util.Random;

import static ru.sapozhnikov.sensorschecker.core.sensor.SensorType.*;

public class Randomizer {

    public int getRandomValue(SensorType type) {
        int x = 0;
        Random random = new Random();
        switch (type) {
            case TEMP:
                x = TEMP.getMin() + random.nextInt(TEMP.getMax() - TEMP.getMin() + 1);
                break;
            case TILT:
                x = TILT.getMin() + random.nextInt(TILT.getMax() - TILT.getMin() + 1);
                break;
            case MOIST:
                x = random.nextInt(MOIST.getMax() + 1);
                break;
        }
        return x;
    }

}
