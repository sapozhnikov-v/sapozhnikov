package objectsorting.shishas;

import objectsorting.Shisha;

public class Hoob extends Shisha {
    private int waterweight;
    private String color="black";
    public Hoob(int waterweight){
        this.waterweight=waterweight;
    }

    public int getWeight() {
        return waterweight+getCupWeight()+20;
    }

    @Override
    public String smoke() {
        return super.smoke()+"вкусный, как твоя мамка";
    }

    @Override
    public double getRating() {
        return 7.9;
    }

    @Override
    public String toString() {
        return "Hoob{" +
                "Общий вес = " + getWeight() +
                ", Рейтинг - " + getRating() +
                '}';
    }
}
