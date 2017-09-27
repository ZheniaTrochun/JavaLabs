package lab5.model;

import java.io.Serializable;

/**
 * Created by zhenia on 23.05.17.
 */
public abstract class Toy implements Serializable {

    protected double price;
    protected String name;
    protected String color;

    public Toy() {
        price = 10;
    }

    public Toy(double price, String name, String color) {
        this.price = price;
        this.name = name;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    @Override
//    public String toString() {
//        return "Toy{" +
//                "price=" + price +
//                ", name='" + name + '\'' +
//                '}';
//        String className = this.getClass().getName();
//        return className.substring(className.lastIndexOf('.') + 1);
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) return false;
//        return getName().equals(((Toy)obj).getName()) && (getPrice() == ((Toy)obj).getPrice());
//    }


    @Override
    public String toString() {
        return "Toy{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (Double.compare(toy.price, price) != 0) return false;
        return name != null ? name.equals(toy.name) : toy.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public abstract Toy convertFromString(String s);
//    public static Toy convertFromString(String s) {
//        return null;
//    }

    public abstract String writeToFile();
}
