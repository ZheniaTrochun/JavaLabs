package lab5.controller;

import lab5.exceptions.InvalidInputDataException;
import lab5.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhenia on 23.05.17.
 */
public class GameRoom {

    private Toy[] toys;

    private static Class[] gamesClasses = {
            Ball.class, BigCar.class, Cube.class, Doll.class, MediumCar.class, SmallCar.class
    };

    public GameRoom(double money, int number) throws IllegalAccessException, InstantiationException, InvalidInputDataException {

        if(number < 6)
            throw new InvalidInputDataException("Incorrect number of toys");

        List<Toy> tmpList = new ArrayList<>();

        double minMoneyAmount = 0;
//        double minPrice = ((Toy)gamesClasses[0].newInstance()).getPrice();

//        for (int i = 0; i < gamesClasses.length; i++) {
//            Toy g = (Toy)gamesClasses[i].newInstance();
//            double gPrice = g.getPrice();
//
//            minMoneyAmount += gPrice;
//            minPrice = minPrice < gPrice ? minPrice : gPrice;
//
//            tmpList.add(g);
//        }

        double minPrice = Arrays.stream(gamesClasses).mapToDouble(g -> {
            try {
                return ((Toy) g.newInstance()).getPrice();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return 0;
        }).min().orElse(0);

        if (money < minMoneyAmount)
            throw new InvalidInputDataException("Money doesn't match number of toys");

        money -= minMoneyAmount;

        while (money > minPrice) {
            for (int i = 0; i < gamesClasses.length; i++) {
                Toy g = (Toy)gamesClasses[i].newInstance();
                double gPrice = g.getPrice();

                if (money > gPrice) {
                    money -= gPrice;
                    tmpList.add(g);
                }
            }
        }

        this.toys = new Toy[tmpList.size()];

        this.toys = tmpList.toArray(this.toys);
    }

    public Toy findGameByPriceDiapasone(double lower, double upper) {
        if ((lower > upper) || (lower < 0)) return null;
        return Arrays.stream(toys).filter(g -> g.getPrice() >= lower && g.getPrice() <= upper).findFirst().orElse(null);
    }

    public Toy[] sortByName() {
        Arrays.sort(toys, (g1, g2) -> g1.getName().compareTo(g2.getName()));

        return toys;
    }

    public Toy[] sortByPrice() {
        Arrays.sort(toys, (g1, g2) -> new Double(g1.getPrice()).compareTo(g2.getPrice()));

        return toys;
    }

    @Override
    public String toString() {
        return "toys=" + Arrays.toString(toys);
    }
}
