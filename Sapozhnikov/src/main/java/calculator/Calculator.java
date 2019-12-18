package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int number1 = reader.nextInt();
        System.out.println("Укажите арифметическую операцию - +, -, *, /");
        char operation = reader.next().charAt(0);
        System.out.println("Введите второе число:");
        int number2 = reader.nextInt();
        int result = calc(number1, number2, operation);
        System.out.println("Результат:");
        System.out.println(result);
    }

    private static int calc(int number1, int number2, char operation) {
        if (operation == '+') {
            int result = number1 + number2;
            return result;
        }
        if (operation == '-') {
            int result = number1 - number2;
            return result;
        }
        if (operation == '*') {
            int result = number1 * number2;
            return result;
        }
        if (operation == '/') {
            int result = number1 / number2;
            return result;
        }
        return 0;
    }
}

