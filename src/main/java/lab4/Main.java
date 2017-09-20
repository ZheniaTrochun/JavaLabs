package lab4;

import lab4.controller.Text;

import java.util.Scanner;

/**
 * Created by zhenia on 14.05.17.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text");

        String text = sc.nextLine();

//        String text = "Some letters with delimiters creating a sentence. lol And sentences - text!";

        Text textController = new Text(text);

        System.out.println(textController.reverse());
        System.out.println(textController.reverse().reverse());
        System.out.println(textController.longestPalindrome());
    }
}


