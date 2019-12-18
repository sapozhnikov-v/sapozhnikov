package objectsorting.shishas;

import objectsorting.Shisha;

public class Khalil extends Shisha {

    private static final int TOBACCO_WEIGHT= 20;
    private int waterweight;
    private String color = "white";

    public Khalil(int waterweight) {
        this.waterweight = waterweight;
    }

    public int getWaterweight() {
        return waterweight;
    }

    public int getWeight() {
        return waterweight + getCupWeight() + TOBACCO_WEIGHT;
    }

    @Override
    public String smoke() {
        return super.smoke() + "в Египте было круче";
    }

    @Override
    public double getRating() {
        return 8.6;
    }

    @Override
    public String toString() {
        return "Khalil{" +
                "Общий вес - " + getWeight() +
                ", Рейтинг - " + getRating() +
                '}';
    }

}
