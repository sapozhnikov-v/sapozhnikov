package sum;

public class Sum {
    public static void main(String[] args) {
        int[] a = new int[]{345, 22, 14, 56, 784, 95, 66, 188, 1024, 7, 686, 2035};
        int x = 0;
        for (int i = 0; i < a.length; i++) {
            x = x + a[i];
        }
        System.out.println(x);
    }
}
