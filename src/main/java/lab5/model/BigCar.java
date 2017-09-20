package lab5.model;

/**
 * Created by zhenia on 23.05.17.
 */
public class BigCar extends Car {

    public BigCar(String name, double price, String color, double size) {
        super(price, name, color, size);
    }

    @Override
    public Toy convertFromString(String s) {
        String[] strs = s.split(", ");

        if (strs.length != 4)
            return null;

        return new BigCar(strs[0], Double.parseDouble(strs[1]), strs[2], Double.parseDouble(strs[1]));
    }

    @Override
    public String writeToFile() {
        return this.getClass().getName() + " | "
                + this.name + ", "
                + this.price + ", "
                + this.color + ", "
                + this.size;
    }
}
