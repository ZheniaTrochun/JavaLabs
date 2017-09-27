package lab8;

import lab5.model.*;
import lab6_7.MySet;

import java.io.*;
import java.util.*;

/**
 * Created by zhenia on 20.09.17.
 */
public class ToySerializator {
    private static Map<String, Class<? extends Toy>> toyMap = createToyMap();

    public static MySet readSetBin(String path) {
        MySet set = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            set = (MySet)ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return set;
    }

    public static void writeSetBin(MySet mySet, String path)  {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path))) {

            writer.writeObject(mySet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MySet readSetByElements(String path) {
        MySet set = new MySet();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))) {

            Object toy = reader.readObject();

            while (toy != null) {
                set.add((Toy)toy);

                toy = reader.readObject();
            }
        } catch (EOFException e) {

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        return set;
    }

    public static void writeSetByElements(MySet mySet, String path) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path))) {

            for (Toy t: mySet) {
                writer.writeObject(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static MySet readSet(String path) {
        MySet res = new MySet();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();

            while (line != null && !line.isEmpty()) {
                String[] lineParts = line.split("\\|");

                if (lineParts.length == 2) {
                    res.add(toyMap.get(lineParts[0].trim())
                            .newInstance()
                            .convertFromString(lineParts[1].trim()));
                }

                line = reader.readLine();
            }
        } catch (IOException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return res;
    }

    public static void writeSet(MySet mySet, String path) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            for (Toy t: mySet) {
                writer.write(t.writeToFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Class<? extends Toy>> createToyMap() {
        Map<String, Class<? extends Toy>> map = new HashMap<>();

        map.put(Ball.class.getName(), Ball.class);
        map.put(BigCar.class.getName(), BigCar.class);
        map.put(Cube.class.getName(), Cube.class);
        map.put(Doll.class.getName(), Doll.class);
        map.put(MediumCar.class.getName(), MediumCar.class);
        map.put(SmallCar.class.getName(), SmallCar.class);

        return map;
    }
}
