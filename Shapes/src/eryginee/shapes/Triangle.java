package eryginee.shapes;

import java.util.Objects;

public class Triangle implements Shape {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    private final double x3;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    @Override
    public double getPerimeter() {
        double sideALength = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double sideBLength = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
        double sideCLength = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));

        return sideALength + sideBLength + sideCLength;
    }

    @Override
    public String toString() {
        return String.format("Triangle[(%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f)]", x1, y1, x2, y2, x3, y3);
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем равенство ссылок
        if (this == obj) return true;

        // Проверка на тип, то есть является ли obj экземпляром класса Triangle
        if (!(obj instanceof Triangle other)) return false;

        // Сравнение параметров (координат вершин треугольников)
        return Double.compare(x1, other.x1) == 0 &&
                Double.compare(y1, other.y1) == 0 &&
                Double.compare(x2, other.x2) == 0 &&
                Double.compare(y2, other.y2) == 0 &&
                Double.compare(x3, other.x3) == 0 &&
                Double.compare(y3, other.y3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, x3, y3);
    }
}
