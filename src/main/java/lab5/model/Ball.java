package lab5.model;

/**
 * Created by zhenia on 23.05.17.
 */
public class Ball extends Toy {

    private double diameter;

    public Ball(String name, double price, String color, double diameter) {
        super(price, name, color);
        this.diameter = diameter;
    }

    public Ball() {
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public Ball convertFromString(String s) {
        String[] strs = s.split(", ");

        if (strs.length != 4)
            return null;

        name = strs[0];
        price = Double.parseDouble(strs[1]);
        color = strs[2];
        diameter = Double.parseDouble(strs[3]);

        return this;
    }

    @Override
    public String writeToFile() {
        return this.getClass().getName() + " | "
                + this.name + ", "
                + this.price + ", "
                + this.color + ", "
                + this.diameter + "\n";
    }
}
