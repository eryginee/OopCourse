package eryginee.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    // Конструктор: Vector(vectorSize), vectorSize - размерность вектора
    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be positive; provided value: ." + vectorSize);
        }

        components = new double[vectorSize];
    }

    // Конструктор копирования: Vector(Vector)
    public Vector(Vector vector) {
        components = vector.components.clone();
    }

    // Конструктор заполнения компонент вектора значениями из массива: Vector(Double[])
    public Vector(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Vector cannot be created from null; provided value: null");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Vector size cannot be zero; provided length: " + array.length);
        }

        components = array.clone();
    }

    // Конструктор заполнения компонент вектора значениями переданного массива: Vector(vectorSize, double[])
    public Vector(int vectorSize, double[] array) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("The vector size must be positive; provided value: ." + vectorSize);
        }

        // Используем Arrays.copyOf для инициализации components
        components = Arrays.copyOf(array, vectorSize);
    }

    // Получение размерности вектора
    public int getSize() {
        return components.length;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        if (components.length == 0) {
            throw new IllegalArgumentException("Vector size cannot be zero; provided length: " + components.length);
        }

        StringBuilder stringBuilder = new StringBuilder(components.length * 4);

        stringBuilder.append('{');

        for (double component : components) {
            stringBuilder.append(component);
            stringBuilder.append(", ");

        }

        // Удаление последней запятой и пробела
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    // Нестатические методы
    public void addVector(Vector vector) {
        int maxSize = Math.max(components.length, vector.components.length);

        for (int i = 0; i < maxSize; i++) {
            if (i < components.length && i < vector.components.length) {
                components[i] += vector.getComponent(i);
            } else if (i < vector.components.length) {
                this.addComponent(vector.getComponent(i)); // Метод добавления новых компонентов, если у текущего вектора меньше элементов
            }
        }
    }

    public void subtractVector(Vector vector) {
        int maxSize = Math.max(components.length, vector.components.length);

        for (int i = 0; i < maxSize; i++) {
            if (i < components.length && i < vector.components.length) {
                components[i] -= vector.getComponent(i);
            } else if (i < vector.components.length) {
                this.addComponent(-vector.getComponent(i)); // Метод добавления новых компонентов с отрицательным значением, если у текущего вектора меньше элементов
            }
        }
    }

    // Метод добавления новой компоненты вектора
    public void addComponent(double value) {
        // Создаем новый массив с увеличенным размером
        double[] newComponents = new double[components.length + 1];

        // Копируем старые компоненты в новый массив
        System.arraycopy(components, 0, newComponents, 0, components.length);

        // Добавляем новый элемент
        newComponents[components.length] = value;

        // Обновляем ссылку на массив компонентов
        components = newComponents;
    }

    // Умножение вектора на скаляр
    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    // Разворот вектора (умножение всех компонент на -1)
    public void reverse() {
        multiplyByScalar(-1);
    }

    // Получение длины вектора
    public double getLength() {
        double sum = 0.0; // Переменная для хранения суммы квадратов компонент вектора

        for (double component : components) {
            sum += component * component;           // Складываем квадраты компонент
        }

        return Math.sqrt(sum); // Извлекаем корень из суммы
    }

    // Получение и установка компоненты вектора по индексу
    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Index out of array bounds: " + index);
        }

        return components[index];
    }


    public void setComponent(int index, double value) {
        if (index < 0 || index >= components.length) {
            throw new IndexOutOfBoundsException("Index out of array bounds: " + index);
        }

        components[index] = value;
    }

    @Override
    public boolean equals(Object object) {
        // Проверка на идентичность
        if (object == this) {
            return true;
        }

        // Проверка соответствия типа
        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        // Приведение типа
        Vector vector = (Vector) object;

        // Сравнение длины
        if (components.length != vector.components.length) {
            return false;
        }

        // Сравнение массивов с компонентами вектора
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = 31 * hash + Arrays.hashCode(components);

        return hash;
    }

    // Статические методы
    public static Vector createSummingVector(Vector vector1, Vector vector2) {
        vector1.addVector(vector2);
        return vector1;
    }

    public static Vector createSubtractingVector(Vector vector1, Vector vector2) {
        vector1.subtractVector(vector2);
        return vector1;
    }

    public static double getDotProduct(Vector vector1, Vector vector2) {
        int minSize = Math.min(vector1.components.length, vector2.components.length);
        double sum = 0;

        for (int i = 0; i < minSize; i++) {
            sum += vector1.components[i] * vector2.components[i];
        }

        return sum;
    }
}
