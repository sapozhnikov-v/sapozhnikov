package sortfromfile;

import java.util.Scanner;

public class ReadName {
    public static String getName(){
    Scanner reader = new Scanner(System.in);
    System.out.println("Введите имя файла:");
    String name = reader.next();
    return name;

    }
}
