package lab5.model;

/**
 * Created by zhenia on 23.05.17.
 */
public class Cube  extends Toy {


    public Cube(String name, double price, String color) {
        super(price, name, color);
    }

    @Override
    public Toy convertFromString(String s) {
        String[] strs = s.split(", ");

        if (strs.length != 3)
            return null;

        return new Cube(strs[0], Double.parseDouble(strs[1]), strs[2]);
    }

    @Override
    public String writeToFile() {
        return this.getClass().getName() + " | "
                + this.name + ", "
                + this.price + ", "
                + this.color;
    }
}
