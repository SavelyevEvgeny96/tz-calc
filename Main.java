package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение: ");

        String stringARequest = scanner.nextLine();

        DataExpression data = new DataExpression(stringARequest);

        Calculator calculator = new Calculator(data);

        System.out.println("Результат - " + "\"" + calculator.getResult() + "\"");
    }
}
