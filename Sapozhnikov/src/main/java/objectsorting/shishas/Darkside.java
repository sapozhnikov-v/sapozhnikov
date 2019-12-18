package objectsorting.shishas;

import objectsorting.Shisha;

public class Darkside extends Shisha {
    private int waterweight;
    private String color="gray";
    public Darkside (int waterweight){
        this.waterweight=waterweight;
    }

    public int getWeight() {
        return waterweight+getCupWeight()+20;
    }

    @Override
    public String smoke() {
        return super.smoke()+"охуенчик";
    }

    @Override
    public double getRating() {
        return 8.8;
    }

    @Override
    public String toString() {
        return "Darkside{" +
                "Общий вес - " + getWeight() +
                ", Рейтинг - " + getRating() +
                '}';
    }
}
