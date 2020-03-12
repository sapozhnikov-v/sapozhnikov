package ru.sapozhnikov.sensorschecker.core.sensor;

import java.util.Date;

public class SensorValue {

    private Integer id;
    private int sensorId;
    private int value;
    private Date date;

    public SensorValue(int sensorId, int value) {
        this.sensorId = sensorId;
        this.value = value;
    }

    public SensorValue(Integer id, int sensorId, int value, Date date) {
        this.id = id;
        this.sensorId = sensorId;
        this.value = value;
        this.date = date;
    }

    public SensorValue() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int id) {
        this.sensorId = id;
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
                ", sensorId=" + sensorId +
                ", value=" + value +
                ", date=" + date +
                '}';
    }

}
