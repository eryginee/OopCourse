package eryginee.range_main;

import eryginee.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(6, 11);

        System.out.println("Длина диапазона чисел равна: " + range.getLength());
        double enteredNumber = 6;

        if (range.isInside(enteredNumber)) {
            System.out.printf("Число %.2f входит в установленный диапазон%n", enteredNumber);
        } else {
            System.out.printf("Число %.2f не входит в установленный диапазон%n", enteredNumber);
        }

        System.out.println();

        range.setFrom(2);
        range.setTo(7);

        System.out.println("Длина измененного диапазона чисел равна: " + range.getLength());

        if (range.isInside(enteredNumber)) {
            System.out.printf("Число %.2f входит в измененный диапазон%n", enteredNumber);
        } else {
            System.out.printf("Число %.2f не входит в измененный диапазон%n", enteredNumber);
        }

        // Создаем второй интервал
        Range secondRange = new Range(1, 6);

        // Проверяем метод getIntersection
        Range intersection = range.getIntersection(secondRange);

        if (intersection != null) {
            System.out.println();
            System.out.println("Пересечение интервалов:");
            System.out.println(intersection);
        } else {
            System.out.println();
            System.out.println("Интервалы не пересекаются.");
        }

        // Проверяем метод getUnion
        Range[] union = range.getUnion(secondRange);
        System.out.println();
        System.out.println("Объединение интервалов:");

        for (Range unionRange : union) {
            System.out.println(unionRange);
        }

        // Проверяем метод getDifference
        Range[] difference = range.getDifference(secondRange);
        System.out.println();

        if (difference == null) {
            System.out.println("Разность интервалов пуста");
        } else {
            System.out.println("Разность интервалов:");

            for (Range differenceRange : difference) {
                System.out.println(differenceRange);
            }
        }
    }
}