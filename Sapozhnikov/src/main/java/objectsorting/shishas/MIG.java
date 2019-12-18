package objectsorting.shishas;

import objectsorting.Shisha;

public class MIG extends Shisha {
        private int waterweight;
        private String color="red";
        private int weighttube;
        public MIG (int waterweight){
            this.waterweight=waterweight;
        }
        public int getWeight (){
            return waterweight+weighttube+getCupWeight()+30;
        }

        @Override
        public String smoke() {
            return super.smoke()+"ништяяяяк";
        }

        @Override
        public double getRating() {
            return 9.3;
        }

        @Override
        public String toString() {
            return "MIG{" +
                    "Общий вес - " + getWeight() +
                    ", Рейтинг - " + getRating() +
                    '}';
        }
    }
