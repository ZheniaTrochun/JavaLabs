package lab3;

import java.util.Scanner;

/**
 * Created by zhenia on 14.05.17.
 */
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        System.out.println("Enter string");

        String a = "";
        while ((a = sc.nextLine()).length() != 0)
            str += a;

        System.out.println("Longest palindrome is");
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String str) {
        StringBuffer text = new StringBuffer(str);
        String res = "";

        for (int i = 0; i < text.length() - 2; i++) {
            for (int j = 2; j < text.length() - i + 1; j++) {
                String tmp = text.substring(i, i + j).trim().toLowerCase();

                if(tmp.equals(new StringBuffer(tmp).reverse().toString()) && tmp.length() > res.length())
                    res = tmp;
            }
        }

        return res;
    }
}
