package eryginee.shapes_main;

import eryginee.shapes.*;
import eryginee.shapes.comparators.AreaComparator;
import eryginee.shapes.comparators.PerimeterComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Triangle(0, 0, 3, 0, 0, 4),
                new Square(6),
                new Circle(5),
                new Rectangle(4, 5),
                new Triangle(2, 3, 5, 3, 2, 6),
                new Circle(11),
                new Square(9),
                new Rectangle(4, 7)
        };

        // Сортируем по площади
        Arrays.sort(shapes, new AreaComparator());
        Shape maxAreaShape = shapes[0];

        System.out.printf("Фигура с максимальной площадью: Тип: %s, Площадь: %.2f%n",
                maxAreaShape.getClass().getSimpleName(), maxAreaShape.getArea());

        // Сортируем по периметру
        Arrays.sort(shapes, new PerimeterComparator());
        Shape secondMaxPerimeterShape = shapes[1]; // Второй элемент после сортировки

        System.out.printf("Фигура со вторым по величине периметром: Тип: %s, Периметр: %.2f%n",
                secondMaxPerimeterShape.getClass().getSimpleName(), secondMaxPerimeterShape.getPerimeter());
    }
}
