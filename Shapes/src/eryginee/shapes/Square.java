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

        // Проверка на null и сравнение классов
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }

        // Сравнение параметров (сторон квадрата)
        Square square = (Square) obj;
        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(sideLength);

        return hash;
    }
}
