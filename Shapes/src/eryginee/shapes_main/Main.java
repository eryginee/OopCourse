package eryginee.shapes_main;

import eryginee.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Triangle(0, 0, 3, 0, 0, 4),
                new Square(6),
                new Circle(5),
                new Rectangle(4, 5),
                new Triangle(2, 3, 5, 3, 2, 6),
                new Circle(11),
                new Square(9),
                new Rectangle(4, 7)
        };

        // Сортировка фигур по площади в порядке убывания
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getArea).reversed());

        Shape maxAreaShape = shapes[0];

        System.out.printf("Фигура с максимальной площадью: Тип: %s, Площадь: %.2f%n",
                maxAreaShape.getClass().getSimpleName(), maxAreaShape.getArea());

        // Сортировка фигур по периметру в порядке убывания
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getPerimeter).reversed());

        // Получаем фигуру со вторым по величине периметром
        Shape secondLargerPerimeterShape = shapes[1];

        System.out.printf("Фигура со вторым по величине периметром: Тип: %s, Периметр: %.2f%n",
                secondLargerPerimeterShape.getClass().getSimpleName(), secondLargerPerimeterShape.getPerimeter());
    }
}
