package eryginee.shapes;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    // Геттеры
    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getX3() {
        return x3;
    }

    public double getY3() {
        return y3;
    }

    // Сеттеры
    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY3(double y3) {
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
        double sideALength = getSideLength(x1, y1, x2, y2);
        double sideBLength = getSideLength(x1, y1, x3, y3);
        double sideCLength = getSideLength(x2, y2, x3, y3);

        return sideALength + sideBLength + sideCLength;
    }

    private double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public String toString() {
        return String.format("Triangle[(%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f)]", x1, y1, x2, y2, x3, y3);
    }

    @Override
    public boolean equals(Object obj) {
        // Проверяем равенство ссылок
        if (this == obj) {
            return true;
        }

        // Проверка на null и сравнение классов
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Triangle other = (Triangle) obj;
        // Сравнение параметров (координат вершин треугольников)
        return (x1 == other.x1 && y1 == other.y1 &&
                x2 == other.x2 && y2 == other.y2 &&
                x3 == other.x3 && y3 == other.y3);
    }

    @Override
    public int hashCode() {
        int result = 17;
        long temp;

        temp = Double.doubleToLongBits(x1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(y1);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(x2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(y2);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(x3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        temp = Double.doubleToLongBits(y3);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        return result;
    }
}

