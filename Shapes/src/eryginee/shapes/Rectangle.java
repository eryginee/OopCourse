package eryginee.shapes;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
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
        if (this == obj) {
            return true;
        }

        // Проверка на null и сравненние классов
        if (obj == null || !(obj.getClass() == this.getClass())) {
            return false;
        }

        Rectangle other = (Rectangle) obj; // Приведение типа
        // Сравнение параметров (ширин и высот)
        return width == other.width && height == other.height;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long tempWidth = Double.doubleToLongBits(width);
        long tempHeight = Double.doubleToLongBits(height);

        result = 31 * result + (int) (tempWidth ^ (tempWidth >>> 32)); // Хеширование width
        result = 31 * result + (int) (tempHeight ^ (tempHeight >>> 32)); //Хеширование height

        return result;
    }
}
