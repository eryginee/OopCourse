package eryginee.shapes;

import java.util.Objects;

public class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Rectangle(width=%.2f, height=%.2f)", width, height);
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем равенство ссылок
        if (this == obj) return true;

        // Проверка на тип, то есть является ли obj экземпляром класса Rectangle
        if (!(obj instanceof Rectangle other)) return false;

        // Сравнение параметров (ширин и высот)
        return Double.compare(width, other.width) == 0 &&
                Double.compare(height, other.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
