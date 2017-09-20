package lab5;

import lab5.controller.GameRoom;
import lab5.exceptions.InvalidInputDataException;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhenia on 23.05.17.
 */
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter money amount and toys number");

        int moneyAmount = sc.nextInt();
        int toysNumber = sc.nextInt();

        try {
            GameRoom room = new GameRoom(moneyAmount, toysNumber);

            System.out.println(room);

            System.out.println(Arrays.toString(room.sortByName()));
            System.out.println(Arrays.toString(room.sortByPrice()));

        } catch (InvalidInputDataException e) {
            e.printStackTrace();
        }
    }
}
