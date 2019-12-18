package average;

public class Average {
    public static void main(String[] args){
        int [] a= new int []{345,22,14,56,784,95,66,188,1024,7,686,13};
        int b=0;
        int c=0;
        for (int i=0; i<a.length; i++){
            b=b+a[i];
            c=b/a.length;
        }
        System.out.println(c);
    }
}
