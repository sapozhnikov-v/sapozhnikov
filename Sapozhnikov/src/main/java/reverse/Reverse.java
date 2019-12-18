package reverse;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] a = new int[]{33, 125, 85, 94, 567, 12, 144, 56, 99, 233};
        int[] array2 = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            array2[i] = a[a.length - 1 - i];
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(array2));
    }
}
