package eryginee.shapes;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return String.format("Square(side=%.2f)", sideLength);
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

        // Сравнение параметров (сторон квадрата)
        Square other = (Square) obj;
        return sideLength == other.sideLength;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long temp = Double.doubleToLongBits(sideLength);

        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }
}
