package lab5.model;

/**
 * Created by zhenia on 23.05.17.
 */
public abstract class Car extends Toy {

    protected double size;

    public Car(double price, String name, String color, double size) {
        super(price, name, color);
        this.size = size;
    }

    public Car() {
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
