package eryginee.shapes;

import java.util.Objects;

public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return String.format("Circle(radius=%.2f)", radius);
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем равенство ссылок
        if (this == obj) return true;

        // Проверка на тип, то есть является ли obj экземпляром класса Circle
        if (!(obj instanceof Circle other)) return false;

        // Сравнение параметров (радиусов окружностей)
        return Double.compare(radius, other.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
