package lab5.model;

/**
 * Created by zhenia on 23.05.17.
 */
public class BigCar extends Car {

    public BigCar(String name, double price, String color, double size) {
        super(price, name, color, size);
    }

    public BigCar() {
    }

    @Override
    public BigCar convertFromString(String s) {
        String[] strs = s.split(", ");

        if (strs.length != 4)
            return null;


        name = strs[0];
        price = Double.parseDouble(strs[1]);
        color = strs[2];
        size = Double.parseDouble(strs[3]);

        return this;
    }

    @Override
    public String writeToFile() {
        return this.getClass().getName() + " | "
                + this.name + ", "
                + this.price + ", "
                + this.color + ", "
                + this.size + "\n";
    }
}
