package lab5.model;

/**
 * Created by zhenia on 23.05.17.
 */
public class Doll extends Toy {

    public Doll(String name, double price, String color) {
        super(price, name, color);
    }

    public Doll() {
    }

    @Override
    public Toy convertFromString(String s) {
        String[] strs = s.split(", ");

        if (strs.length != 3)
            return null;

        name = strs[0];
        price = Double.parseDouble(strs[1]);
        color = strs[2];

        return this;
    }

    @Override
    public String writeToFile() {
        return this.getClass().getName() + " | "
                + this.name + ", "
                + this.price + ", "
                + this.color + "\n";
    }
}
