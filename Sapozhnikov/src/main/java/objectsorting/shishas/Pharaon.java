package objectsorting.shishas;

import objectsorting.Shisha;

public class Pharaon extends Shisha {
    private int waterweight;
    private String color="green";
    public Pharaon (int waterweight){
        this.waterweight=waterweight;
    }

    private int getFullWeight(int tobaccoweight){
        return tobaccoweight+waterweight+getCupWeight()+20;
    }

    public int getWeight() {
        return getFullWeight(5);
    }

    public double getRating(){
        return 7.8;
    }

    @Override
    public String smoke() {
        return super.smoke()+"заебись дымит";
    }

    @Override
    public String toString() {
        return "Pharaon{" +
                "Общий вес - " + getWeight() +
                ", Рейтинг - " + getRating() +
                '}';
 }
}

