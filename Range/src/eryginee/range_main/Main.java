package eryginee.range_main;

import eryginee.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(6, 11);

        System.out.println("Длина диапазона чисел равна: " + range1.getLength());
        double enteredNumber = 6;

        if (range1.isInside(enteredNumber)) {
            System.out.printf("Число %.2f входит в установленный диапазон%n", enteredNumber);
        } else {
            System.out.printf("Число %.2f не входит в установленный диапазон%n", enteredNumber);
        }

        System.out.println();

        range1.setFrom(2);
        range1.setTo(6);

        System.out.println("Длина измененного диапазона чисел равна: " + range1.getLength());

        if (range1.isInside(enteredNumber)) {
            System.out.printf("Число %.2f входит в измененный диапазон%n", enteredNumber);
        } else {
            System.out.printf("Число %.2f не входит в измененный диапазон%n", enteredNumber);
        }

        // Создаем второй интервал
        Range range2 = new Range(1, 6);

        // Проверяем метод getIntersection
        Range intersection = range1.getIntersection(range2);

        if (intersection != null) {
            System.out.println();
            System.out.println("Пересечение интервалов:");
            System.out.println(intersection);
        } else {
            System.out.println();
            System.out.println("Интервалы не пересекаются.");
        }

        // Проверяем метод getUnion
        Range[] union = range1.getUnion(range2);
        System.out.println();
        System.out.println("Объединение интервалов:");

        for (Range range : union) {
            System.out.println(range);
        }

        // Проверяем метод getDifference
        Range[] difference = range1.getDifference(range2);
        System.out.println();

        if (difference.length == 0) {
            System.out.println("Разность интервалов пуста");
        } else {
            System.out.println("Разность интервалов:");

            for (Range range : difference) {
                System.out.println(range);
            }
        }
    }
}