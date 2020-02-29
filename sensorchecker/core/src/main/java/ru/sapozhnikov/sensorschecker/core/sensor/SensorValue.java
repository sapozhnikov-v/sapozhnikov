package ru.sapozhnikov.sensorschecker.core.sensor;

public class SensorValue {

    private int id;
    private int value;

    public SensorValue(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public SensorValue() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorValue{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
