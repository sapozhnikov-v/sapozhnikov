package ru.sapozhnikov.sensorschecker.emulator.sensor.emulator;

import ru.sapozhnikov.sensorschecker.core.sensor.SensorType;

import java.util.Random;

public class Randomizer {

    private int min;
    private int max;

    public int getRandomValue(SensorType type) {
        int x = 0;
        Random random = new Random();
        switch (type) {
            case TEMP:
                min = -50;
                max = 50;
                x = min + random.nextInt(max - min + 1);
                break;
            case TILT:
                min = -180;
                max = 180;
                x = min + random.nextInt(max - min + 1);
                break;
            case MOIST:
                max = 100;
                x = random.nextInt(max + 1);
                break;

        }
        return x;
    }

}
