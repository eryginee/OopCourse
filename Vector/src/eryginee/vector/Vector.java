package eryginee.vector;

public class Vector {
    private final double[] components;

    // Конструктор: Vector(n), n - размерность вектора
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительной");
        }

        components = new double[n];
    }

    // Конструктор копирования: Vector(Vector)
    public Vector(Vector other) {
        this.components = other.components.clone();
    }

    // Конструктор заполнения компонент вектора значениями из массива: Vector(Double[])
    public Vector(double[] array) {
        components = array.clone();
    }

    // Конструктор заполнения компонент вектора значениями переданного массива: Vector(n, double[])
    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть положительной");
        }

        components = new double[n];

        for (int i = 0; i < n; i++) {
            components[i] = (i < array.length) ? array[i] : 0.0;
        }
    }

    // Получение размерности вектора
    public int getSize() {
        return components.length;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < components.length; i++) {
            stringBuilder.append(components[i]);

            if (i < components.length - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("}");
        return stringBuilder.toString();

    }

    // Нестатические методы
    public Vector addVectors(Vector other) {
        int maxSize = Math.max(this.getSize(), other.getSize());
        Vector result = new Vector(maxSize);

        for (int i = 0; i < maxSize; i++) {
            result.components[i] = this.getComponent(i) + other.getComponent(i);
        }

        return result;
    }

    public Vector subtractVectors(Vector other) {
        int maxSize = Math.max(this.getSize(), other.getSize());
        Vector result = new Vector(maxSize);

        for (int i = 0; i < maxSize; i++) {
            result.components[i] = this.getComponent(i) - other.getComponent(i);
        }

        return result;
    }

    // Умножение вектора на скаляр
    public Vector multiplyVectorByScalar(double scalar) {
        Vector result = new Vector(this.getSize());

        for (int i = 0; i < this.getSize(); i++) {
            result.components[i] = this.components[i] * scalar;
        }

        return result;
    }

    // Разворот вектора (умножение всех компонент на -1)
    public Vector getReversedVector() {
        Vector result = new Vector(this.getSize());

        for (int i = 0; i < this.getSize(); i++) {
            result.components[i] = -this.components[i];
        }

        return result;
    }

    // Получение длины вектора
    public double getVectorLength() {
        double sum = 0.0; // Переменная для хранения суммы квадратов компонент вектора

        for (double comp : components) {
            sum += comp * comp;           // Складываем квадраты компонент
        }

        return Math.sqrt(sum); // Извлекаем корень из суммы
    }

    // Получение и установка компоненты вектора по индексу
    public double getComponent(int index) {
        return (index >= 0 && index < components.length) ? components[index] : 0.0;
    }

    public void setComponent(int index, double value) {
        if (index >= 0 && index < components.length) {
            components[index] = value;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true; // Проверка на идентичность

        if (!(object instanceof Vector)) return false; // Проверка типа

        Vector other = (Vector) object; // Приведение типа

        // Сравнение длины
        if (this.getSize() != other.getSize()) return false;

        for (int i = 0; i < this.getSize(); i++) {
            if (this.components[i] != other.components[i]) return false;
        }

        return true; // Все проверки пройдены
    }

    @Override
    public int hashCode() {
        int result = 1;

        for (double comp : components) {
            result = 31 * result + Double.hashCode(comp);
        }

        return result;
    }

    // Статические методы
    public static Vector addVectors(Vector vector1, Vector vector2) {
        return vector1.addVectors(vector2);
    }

    public static Vector subtractVectors(Vector vector1, Vector vector2) {
        return vector1.subtractVectors(vector2);
    }

    public static double vectorsDotProduct(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.getSize(), vector2.getSize());
        double sum = 0;

        for (int i = 0; i < maxSize; i++) {
            double vector1Component = i < vector1.getSize() ? vector1.components[i] : 0;
            double vector2Component = i < vector2.getSize() ? vector2.components[i] : 0;
            sum += vector1Component * vector2Component;
        }

        return sum;
    }
}

