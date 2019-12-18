package index;

import java.util.Arrays;

public class Index {


    private static int searchIndex(int[] array, int b, boolean search) {
        if (search) {
            return searchIndexFirst(array, b);
        } else {
            return searchIndexLast(array, b);
        }
    }

    private static int searchIndexFirst(int[] array, int b) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == b) {
                return i;
            }
        }
        return -1;
    }

    private static int searchIndexLast(int[] array, int b) {
        int x = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == b) {
                x = i;
            }
        }
        return x;
    }

    private static int[] getArray() {
        return new int[]{45, 11, 1, 67, 79, 955, 616, 48, 1024, 12, 99, 205, 1024};
    }

    public static void xuy() {
    }

    public static void main(String[] args) {
        Index a = new Index();
        System.out.println(a.searchIndex(a.getArray(), 1024, true));
        // System.out.println(a.searchIndex(c, 1024,true));
        // System.out.println(a.searchIndex(c, 10000,true));
        xuy();
    }
}