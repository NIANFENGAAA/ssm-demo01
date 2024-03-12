package com.zwq;

import Jama.Matrix;
import org.junit.Test;

import java.util.Scanner;

public class jamaTest {
    public static void main(String[] args) {
        int a1,b1,a2,b2;
        Scanner scanner = new Scanner(System.in);
        a1 = scanner.nextInt();
        b1 = scanner.nextInt();

        a2 = scanner.nextInt();
        b2 = scanner.nextInt();
        double[][] x1 = new double[a1][b1];
        Matrix matrix1 = new Matrix(x1);
        double[][] x2 = new double[a1][b1];
        Matrix matrix2 = new Matrix(x2);
        matrix1.print(a1,2);

        matrix1.set(0,0,1);
        matrix1.set(0,1,2);
        matrix1.print(a1,1);

//        matrix2.set(0,1,3);
//        matrix2.set(0,2,3);
//        matrix2.set(2,1,5);
//
//        Matrix matrix = matrix1.plus(matrix2);
//        matrix.print(a1,1);








    }
}
