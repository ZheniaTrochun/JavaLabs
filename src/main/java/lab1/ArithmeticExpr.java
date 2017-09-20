package lab1;

import java.util.Scanner;

/**
 * Created by zhenia on 14.05.17.
 */
public class ArithmeticExpr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n and n-step");

        float n = sc.nextFloat();
        float nStep = sc.nextFloat();

        System.out.println("Enter m and m-step");

        float m = sc.nextFloat();
        float mStep = sc.nextFloat();

        System.out.println("Expression result");
        System.out.println(expressionCalculator(n, nStep, m, mStep));
    }

    public static double expressionCalculator(float n, float nStep, float m, float mStep) {
        double res = 0;

        for (float i = 0; i < n; i += nStep) {
            if(i == 1) continue;

            for (float j = 0; j < m; j += mStep) {
                res += (i - j)/(i - 1);
            }
        }

        return res;
    }
}
