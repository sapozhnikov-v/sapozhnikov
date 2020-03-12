package ru.sapozhnikov.sensorschecker.core.sensor;

public class Truck {

    private Integer id;
    private String name;
    private String number;

    public Truck(Integer id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Truck() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

}
