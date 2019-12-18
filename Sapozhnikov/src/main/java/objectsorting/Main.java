package objectsorting;

import objectsorting.shishas.*;

import java.util.Arrays;

public class Main {

    public Shisha[] sort(Shisha[] array){

                boolean sorted = true;
        do {
            sorted = true;
            for (int i=0; i<array.length-1; i++){
                if (array[i].getWeight()>array[i+1].getWeight() || ((array[i].getWeight()==array[i+1].getWeight())&&(array[i].getRating()<array[i+1].getRating()))){
                    Shisha w = array[i+1];
                    array[i+1] = array[i];
                    array[i] = w;
                    sorted=false;
                }
              /*  if (array[i].getWeight()==array[i+1].getWeight()){
                    if (array[i].getRating()<array[i+1].getRating()){
                        Shisha w = array[i+1];
                        array[i+1] = array[i];
                        array[i] = w;
                        sorted=false;
                    }
                }*/
            }
        }
        while(!sorted);

        return array;

    }
      public static void main(String[] args){
        Main a = new Main();
        Shisha [] b = new Shisha []{new Khalil(20), new MIG(30), new Hoob(45),
                new MattPear(25), new Darkside(25), new Pharaon(25)};
        Shisha [] c = new Shisha[b.length];
        for (int i=0; i<b.length; i++){
            c[i]=b[i];
        }
        Shisha [] result = a.sort(c);
        Khalil khalil1 = new Khalil (1);
          System.out.println((khalil1).getWaterweight());
        Khalil khalil2 = new Khalil(4);
          System.out.println((khalil1).getWaterweight());
        System.out.println(Arrays.toString(b));
        System.out.print(Arrays.toString(result));


    }


}
