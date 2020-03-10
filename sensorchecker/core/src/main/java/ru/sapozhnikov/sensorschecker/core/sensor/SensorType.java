package ru.sapozhnikov.sensorschecker.core.sensor;

public enum SensorType {
    TEMP(-50,50),
    MOIST(0,100),
    TILT(-180,180);

    private int min;
    private int max;

    SensorType(int min, int max) {
        this.min = min;
        this.max = max;
    }

    SensorType(){

    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
