package utils;

import java.io.*;
import java.util.Scanner;

/**
 * Created by zhenia on 14.05.17.
 */
public class MatrixUtils {

    public static <T> void matrixOutput(PrintStream out, T[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                out.print(String.format("%s\t", matrix[i][j]));
            }
            out.println();
        }
    }
}
