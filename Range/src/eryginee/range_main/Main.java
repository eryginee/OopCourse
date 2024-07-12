package eryginee.range_main;

import java.util.Scanner;
import eryginee.range.Range;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range = new Range(10.45, 27.68);

        System.out.println("Длина диапазона чисел равна: " + range.getLength());

        System.out.println("Введите число для проверки:");
        double enteredNumber = scanner.nextDouble();

        if (range.isInside(enteredNumber)) {
            System.out.printf("Число %.2f входит в установленный диапазон%n", enteredNumber);
        } else {
            System.out.printf("Число %.2f не входит в установленный диапазон%n", enteredNumber);
        }

        System.out.println();

        range.setFrom(35.54);
        range.setTo(57.93);

        System.out.println("Длина измененного диапазона чисел равна: " + range.getLength());

        if (range.isInside(enteredNumber)) {
            System.out.printf("Число %.2f входит в измененный диапазон%n", enteredNumber);
        } else {
            System.out.printf("Число %.2f не входит в измененный диапазон%n", enteredNumber);
        }
    }
}