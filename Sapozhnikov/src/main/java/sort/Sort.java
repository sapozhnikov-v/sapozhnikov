package sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        int [] a= new int []{345,22,14,56,784,95,66,188,1024,7,686,17};
        int[] arr2 = new int[a.length];{
            for (int i=0; i<a.length; i++){
                arr2[i]=a[i];
            }
        }
        boolean sorted = true;
        do {
            sorted = true;
            for (int i=0; i<a.length-1; i++){
                if (arr2[i]>arr2[i+1]){
                    int b = arr2[i+1];
                    arr2[i+1] = arr2[i];
                    arr2[i] = b;
                    sorted=false;
                }
            }
        }
        while(!sorted);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(arr2));
    }
}