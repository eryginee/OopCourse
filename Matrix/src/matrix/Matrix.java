package matrix;

import java.util.Vector;

public class Matrix  {
    private Vector[] rows;

    // Матрица нулей размером n строк x m столбцов
    public Matrix(int n, int m) {
        rows = new Vector[n];
        for (int i = 0; i < n; i++) {
            rows[i] = new Vector(m);
        }
    }

    // Конструктор копирования матрицы
    public Matrix(Matrix other) {
        int n = other.getRowCount();
    }

    // Получение размеров матрицы
    public int getRowCount() {
        return rows.length;
    }

    //public int getColCount() {
        //return rows[0] != null ? rows[0].getSize() : 0;
    //}
}
