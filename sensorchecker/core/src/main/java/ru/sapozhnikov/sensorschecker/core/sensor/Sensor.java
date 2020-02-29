package ru.sapozhnikov.sensorschecker.core.sensor;

public class Sensor {

    private int id;
    private SensorType type;
    private String name;
    private int idTruck;

    public Sensor(int id, SensorType type, String name, int idTruck) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.idTruck = idTruck;
    }

    public Sensor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", idTruck=" + idTruck +
                '}';
    }
}
