package eryginee.matrix;

import eryginee.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;
    private int rowCount;
    private int colCount;

    // Матрица нулей размером n x m
    public Matrix(int n, int m) {
        rowCount = Math.max(n, 0); // Задаем количество строк, если n <= 0, устанавливаем 0
        colCount = Math.max(m, 0); // Задаем количество столбцов, если m <= 0, устанавливаем 0
        rows = new Vector[rowCount]; // Инициализация массива строк

        for (int i = 0; i < rowCount; i++) {
            rows[i] = new Vector(colCount); // Каждая строка - это вектор заданной длины
        }
    }

    // Конструктор копирования: создает новую матрицу на основе существующей
    public Matrix(Matrix matrix) {
        if (matrix == null) {
            rowCount = 0; // если матрица равна null, создаем пустую матрицу
            colCount = 0;
            rows = new Vector[0];
            return;
        }

        rowCount = matrix.rowCount; // Копируем размеры из существующей матрциы
        colCount = matrix.colCount;
        rows = new Vector[rowCount]; // Создаем новый массив для строк

        for (int i = 0; i < rowCount; i++) {
            if (matrix.rows[i] != null) {
                // Копируем каждую строку, дополняя её нулями до нужного размера
                double[] formattedRow = new double[colCount];

                for (int j = 0; j < matrix.rows[i].getSize(); j++) {
                    formattedRow[j] = matrix.rows[i].getComponent(j); // Используем геттер
                }

                Arrays.fill(formattedRow, matrix.rows[i].getSize(), colCount, 0); // Заполнение нулями
                rows[i] = new Vector(formattedRow);
            } else {
                rows[i] = new Vector(colCount); // Заполняем нулями, если строка null
            }
        }
    }

    public Matrix(double[][] array) {                       // Конструктор матрицы из двумерного массива
        rowCount = (array != null) ? array.length : 0;      // Определяем количество строк
        colCount = 0;                                       // Изначально количество столбцов равно 0

        //Определяем максимальную длину строк для установки количества столбцов
        for (int i = 0; i < rowCount; i++) {
            if (array[i] != null) {
                colCount = Math.max(colCount, array[i].length); // Устанавливаем максимальное количество столбцов
            }
        }

        rows = new Vector[rowCount];

        for (int i = 0; i < rowCount; i++) {
            if (array[i] == null) {
                rows[i] = new Vector(colCount); // Заполняем нулями, если строка null
            } else {
                // Создаем вектор и заполняем вго значениями или нулями, если длина меньше colCount
                double[] formattedRow = new double[colCount];

                for (int j = 0; j < array[i].length; j++) {
                    formattedRow[j] = array[i][j]; // Копирукм значения
                }

                Arrays.fill(formattedRow, array[i].length, colCount, 0); // Заполнение нулями
                rows[i] = new Vector(formattedRow);
            }
        }
    }

    // Конструктор создает матрицу из массива векторов-строк
    public Matrix(Vector[] vectors) {
        rowCount = (vectors != null) ? vectors.length : 0; // Определяем количество строк
        colCount = (rowCount > 0 && vectors[0] != null) ? vectors[0].getSize() : 0; // Определяем количество столбцов

        rows = new Vector[rowCount]; // Инициализация массива строк

        for (int i = 0; i < rowCount; i++) { // Цикл для прохода по строкам матрицы
            if (vectors[i] == null) {
                rows[i] = new Vector(colCount); // Заполняем нулями, есл вектор null
            } else {
                // Копируем вектор и заполняем его недостающие элементы нулями
                double[] formattedVector = new double[colCount];

                for (int j = 0; j < vectors[i].getSize(); j++) {
                    formattedVector[j] = vectors[i].getComponent(j); // Используем геттер из класса Vector
                }

                Arrays.fill(formattedVector, vectors[i].getSize(), colCount, 0); // Заполненеие нулями
                rows[i] = new Vector(formattedVector); // Копируем векторы
            }
        }
    }

    // Метод, возвращающий размеры матрицы
    public int[] size() {
        return new int[]{rowCount, colCount}; // Возвращает массив с количеством строк и столбцов
    }

    // Метод, возвращающий строку матрицы по индексу
    public Vector getRow(int index) {
        if (index < 0 || index >= rowCount) {
            throw new IndexOutOfBoundsException("Invalid row index: " + index);
        }

        return rows[index]; // Возврат строки
    }

    // Метод, устанавливающий строку матрицы по индексу
    public void setRow(int index, Vector vector) {
        if (index < 0 || index >= rowCount) {
            throw new IndexOutOfBoundsException("Invalid row index:" + index);
        }

        if (vector.getSize() != colCount) {
            throw new IllegalArgumentException("Vector size must match column count.");
        }

        rows[index] = new Vector(vector); // Установка строки
    }
}