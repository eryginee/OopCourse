package eryginee.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
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
        if (this == obj) {
            return true;
        }

        // Проверка на null и сравненние классов
        if (obj == null || !(obj.getClass() == this.getClass())) {
            return false;
        }

        // Сравнение параметров (радиусов окружностей)
        Circle other = (Circle) obj;
        return radius == other.radius;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long temp = Double.doubleToLongBits(radius); // Преобразуем radius в long

        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }
}
