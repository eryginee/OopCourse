package eryginee.shapes;

import java.util.Objects;

public class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side; // Ширина квадрата
    }

    @Override
    public double getHeight() {
        return side; // Высота квадрата
    }

    @Override
    public double getArea() {
        return side * side; // Площадь квадрата
    }

    @Override
    public double getPerimeter() {
        return 4 * side; // Периметр квадрата
    }

    @Override
    public String toString() {
        return String.format("Square(side=%.2f)", side);
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем равенство ссылок
        if (this == obj) return true;

        // Проверка на тип, то есть является ли obj экземпляром класса Square
        if (!(obj instanceof Square other)) return false;

        // Сравнение параметров (ширин и высот)
        return Double.compare(side, other.side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}
