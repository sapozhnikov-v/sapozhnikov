package objectsorting.shishas;

import objectsorting.Shisha;

public class MattPear extends Shisha {
    private int waterweight;
    private String color = "blue";

    public MattPear(int waterweight) {
        this.waterweight = waterweight;
    }

    public int getWeight() {
        return waterweight + getCupWeight() + 20;
    }

    @Override
    public double getRating() {
        return 9.5;
    }

    @Override
    public String smoke() {
        return super.smoke()+"пыщ-пыщ";
    }

    @Override
    public String toString() {
        return "MattPear{" +
                "Общий вес - " + getWeight() +
                ", Рейтинг - " + getRating() +
                '}';
    }
}
