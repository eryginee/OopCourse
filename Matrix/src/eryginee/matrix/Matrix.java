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

    // Метод, возвращающий вектор-столбец по индексу
    public Vector getColumn(int index) {
        if (index < 0 || index >= colCount) {
            throw new IndexOutOfBoundsException("Invalid column index: " + index);
        }

        double[] column = new double[rowCount];

        for (int i = 0; i < rowCount; i++) {
            column[index] = rows[i].getComponent(index); // Получение элементов столбца из каждой строки
        }

        return new Vector(column); // Возвращаем вектор-столбец
    }

    // Метод транспонирования матрицы
    public Matrix transpose() {
        Matrix transposed = new Matrix(colCount, rowCount); // Создание транспонированной матрицы

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                // Получаем компонент текущей строки i и столбца j
                double component = getRow(i).getComponent(j);

                // Установка компонента в транспонированную матрицу, создаем новый вектор из одного компонента
                transposed.getRow(j).setComponent(i, component);
            }
        }

        return transposed; // Возврат транспонированной матрицы
    }

    // Умножение матрицы на скаляр
    public Matrix multiplyByScalar(double scalar) {
        Matrix result = new Matrix(rowCount, colCount); // Создаем результирующую матрицу

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result.getRow(i).setComponent(j, rows[i].getComponent(j) * scalar);
            }
        }

        return  result;
    }

    // Вычисление определителя матрицы
    public double getDeterminant() {
        if (rowCount != colCount) {
            throw new IllegalArgumentException("Determinant con only be calculated fore square matrices.");
        }

        // Если матрица 1х1
        if(rowCount == 1) {
            return rows[0].getComponent(0);
        }

        // Если матрица 2х2
        if (rowCount == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1)
                    - rows[0].getComponent(1) * rows[1].getComponent(0);
        }

        double determinant = 0; // Инициализация определителя

        for (int j = 0; j < colCount; j++) {
            // создаем минор для текущего элемента
            Matrix minor = getMinor(0,j);
            // Используем рекурсию для вычисления определителя
            determinant += Math.pow(-1, j) * rows[0].getComponent(j) * minor.getDeterminant();
        }

        return determinant; // Возврат итогового значения определителя
    }

    // Метод для получения минор-матрицы
    private Matrix getMinor(int row, int column) {
        Matrix minor = new Matrix(rowCount - 1, colCount - 1);
        int minorRow = 0; // Индекс для строк минор-матрицы

        for (int i = 0; i < rowCount; i++) {
            if (i == row) continue; // Пропускаем строку, из которой создаем минор

            int minorColumn = 0; // Индекс для столбцов минор-матрицы

            for (int j = 0; j <colCount; j++) {
                if (j == column) continue; // Пропускаем столбуц, из которого создаем минор

                minor.getRow(minorRow).setComponent(minorColumn, rows[i].getComponent(j));
                minorColumn++;
            }

            minorRow++;
        }

        return minor; // Возвращаем минор-матрицу
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        for (int i = 0; i < rowCount; i++) {
            result.append(rows[i].toString()); // Формируем вывод строк матрицы

            if (i < rowCount - 1) {
                result.append(", "); // Разделяем строки запятой
            }
        }

        result.append(")");
        return result.toString(); // Возврат строкового представления матрицы
    }

    // Умножение матрицы на вектор
    public Vector multiplyByVector(Vector vector) {
        if (colCount != vector.getSize()) {
            throw new IllegalArgumentException("Matrix column size must match vector size.");
        }

        double[] result = new double[rowCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                result[i] += rows[i].getComponent(j) * vector.getComponent(j); // Умножение каждой строки на вектор
            }
        }

        return new Vector(result); // Возврат вектора результата
    }

    // Метод сложения двух матриц
    public Matrix getMatricesSum(Matrix other) {
        if (this.rowCount != other.rowCount || this.colCount != other.colCount) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        Matrix result = new Matrix (rowCount, colCount); // Создаем результирующую матрицу

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                double sum = this.rows[i].getComponent(j) + other.getRow(i).getComponent(j);
                result.getRow(i).setComponent(j, sum); // Устанавливаем сумму в результирующую матрицу
            }
        }

        return result; // Возвращаем результирующую матрицу
    }

    // Метод вычитания двух матриц
    public Matrix getMatricesDifference(Matrix other) {
        if (this.rowCount != other.rowCount || this.colCount != other.colCount) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        Matrix result = new Matrix (rowCount, colCount); // Создаем результирующую матрицу

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                double difference = this.rows[i].getComponent(j) - other.getRow(i).getComponent(j);
                result.getRow(i).setComponent(j, difference); // Устанавливаем разность в результирующую матрицу
            }
        }

        return result; // Возвращаем результирующую матрицу
    }
    
    // Статический метод сложения двух матриц
    public static Matrix getMatricesSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rowCount != matrix2.rowCount || matrix1.colCount != matrix2.colCount) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }

        Matrix result = new Matrix (matrix1.rowCount, matrix2.colCount); // Создаем результирующую матрицу

        for (int i = 0; i < matrix1.rowCount; i++) {
            for (int j = 0; j < matrix2.colCount; j++) {
                result.getRow(i).setComponent(j, matrix1.rows[i].getComponent(j) + matrix2.rows[i].getComponent(j)); // Устанавливаем сумму в результирующую матрицу
            }
        }

        return result; // Возвращаем результирующую матрицу
    }

    // Статический етод вычитания двух матриц
    public static Matrix getMatricesDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rowCount != matrix2.rowCount || matrix1.colCount != matrix2.colCount) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }

        Matrix result = new Matrix(matrix1.rowCount, matrix2.colCount); // Создаем результирующую матрицу

        for (int i = 0; i < matrix1.rowCount; i++) {
            for (int j = 0; j < matrix2.colCount; j++) {
                result.getRow(i).setComponent(j, matrix1.rows[i].getComponent(j) - matrix2.rows[i].getComponent(j)); // Вычитание соответсвующих элементов
            }
        }

        return result; // Возвращаем результирующую матрицу
    }

    // Статический метод умножения двух матриц
    public static Matrix getMatricesProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.colCount != matrix2.rowCount) {
            throw new IllegalArgumentException("Invalid dimensions for matrix multiplication.");
        }

        Matrix result = new Matrix(matrix1.rowCount, matrix2.colCount); // Создаем результирующую матрицу

        for (int i = 0; i < matrix1.rowCount; i++) {
            for (int j = 0; j < matrix2.colCount; j++) {
                double sum = 0; // Сумма для текущего элемента результирующей матрицы

                for (int k = 0; k < matrix1.colCount; k++) {
                    sum += matrix1.rows[i].getComponent(k) * matrix2.rows[k].getComponent(j); // Умножение строки на столбцы
                }

                result.getRow(i).setComponent(j, sum); /// Заполнение результата
            }
        }

        return result;
    }
}