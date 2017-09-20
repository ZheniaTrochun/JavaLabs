package lab2;

import utils.MatrixUtils;

import java.util.Scanner;

/**
 * Created by zhenia on 14.05.17.
 */
public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, r, q;

        System.out.println("Enter matrices sizes");

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        q = sc.nextInt();

        byte[][] a = inputMatrix(n, m, "Enter first matrix", sc);

        byte[][] b = inputMatrix(r, q, "Enter second matrix", sc);

//        byte[][] a = {{1, 1, 1},
//                     {1, 1, 1}};
//
//        byte[][] b = {{1, 1},
//                     {1, 1},
//                     {1, 1}};

        Integer[][] c = matrixMultiplication(a, b);

        System.out.println("Result");
        MatrixUtils.matrixOutput(System.out, c);

        System.out.println("Max sum");
        System.out.println(sumMax(c));

        System.out.println("Min sum");
        System.out.println(sumMin(c));
    }

    public static Integer[][] matrixMultiplication(byte[][] a, byte[][] b) {
        if(a == null || b == null) {
            System.out.println("Incorrect input");

            return null;
        }

        if(a[0].length != b.length) {
            System.out.println("Incorrect input");

            return null;
        }

        Integer[][] res = new Integer[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                res[i][j] = new Integer(0);
                for (int k = 0; k < b.length; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return res;
    }

    public static int sumMax(Integer[][] c) {
        int res = 0;

        for (int i = 0; i < c[0].length; i++) {

            if(i % 2 == 0) continue;

            int max = c[0][i];

            for (int j = 0; j < c.length; j++) {
                if(c[j][i] > max) max = c[j][i];
            }

            res += max;
        }

        return res;
    }

    public static int sumMin(Integer[][] c) {
        int res = 0;

        for (int i = 0; i < c[0].length; i++) {

            if(i % 2 == 1) continue;

            Integer min = c[0][i];

            for (int j = 0; j < c.length; j++) {
                if(c[j][i] < min) min = c[j][i];
            }

            res += min;
        }

        return res;
    }

    private static byte[][] inputMatrix(int n, int m, String msg, Scanner sc) {
        System.out.println(msg);

        byte[][] a = new byte[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextByte();
            }
        }

        return a;
    }
}
