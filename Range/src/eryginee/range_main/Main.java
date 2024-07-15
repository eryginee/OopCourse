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

        // Создаем второй интервал
        Range secondRange = new Range(39.00, 56.03);

        // Проверяем метод getIntersection
        Range intersectionResult = range.getIntersection(secondRange);
        if (intersectionResult != null) {
            System.out.println("\nПересечение интервалов:");
            System.out.println(intersectionResult);
        } else {
            System.out.println("\nИнтервалы не пересекаются.");
        }

        // Проверяем метод getUnion
        Range[] unionResult = range.getUnion(secondRange);
        System.out.println();
        System.out.println("Объединение интервалов:");
        for (Range rangeResult : unionResult) {
            System.out.println(rangeResult);
        }

        // Проверяем метод getDifference
        Range[] differenceResult = range.getDifference(secondRange);
        System.out.println("\nРазность интервалов:");
        for (Range rangeResult : differenceResult) {
            System.out.println(rangeResult);
        }
    }
}