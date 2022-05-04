package com.geekbrains.lesson4.hw4;

import static java.lang.Math.sqrt;

public class Triangle {

    public int calculateArea(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Стороны должны быть >= 0");
        }
        if (a == b + c || b == a + c || c == a + b) {
            throw new TriangleException("Треугольник вырожденный");
        }
        double p = (a + b + c) / 2.0;
        return (int) sqrt(p * (p - a) * (p - b) * (p - c));
    }


//    public static void main(String[] args) {
//        Triangle triangle = new Triangle();
//
//        System.out.println(triangle.calculateArea(2, 3, 4));
//    }
}
