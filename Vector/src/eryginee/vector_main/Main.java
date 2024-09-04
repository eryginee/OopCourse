package eryginee.vector_main;

import eryginee.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3); // Создание вектора размерности 3
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4}); // Заполнение вектора значениями из массива
        Vector vector3 = new Vector(2, new double[]{4, 5}); // Заполнение компонент вектора значениями элементов передаваемого массива

        System.out.println("vector1: " + vector1);
        System.out.println("vector2: " + vector2);
        System.out.println("vector3: " + vector3);
        System.out.println();

        Vector vector4 = Vector.createSummingVector(vector2, vector3); // Сложение векторов
        System.out.println("vector4 = vector2 + vector3 = " + vector4);

        Vector vector5 = Vector.createSubtractingVector(vector1, vector3); // Вычитание векторов
        System.out.println("vector5 = vector1 - vector3 = " + vector5);
        System.out.println();

        double dotProduct = Vector.getDotProduct(vector4, vector5);
        System.out.println("Скалярное произведение vector4 и vector5 равно: " + dotProduct);
    }
}
