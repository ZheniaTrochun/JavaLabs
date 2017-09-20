package lab8;

import lab5.model.*;
import lab6_7.MySet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Created by zhenia on 20.09.17.
 */
public class ToySerializator {
    private static Map<String, Class<? extends Toy>> toyMap = createToyMap();

    public static MySet setReader(String path) throws IOException {
        MySet res = new MySet();

        List<String> lines = Files.readAllLines(Paths.get(path));

        Cube.serialize(lines.get(0));

        lines.forEach(l -> {
            try {
                res.add(toyMap.get(l.split("\\|")[0].trim())
                        .newInstance()
                        .convertFromString(l.split("\\|")[1].trim()));
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        return res;
    }

    public static void writeSetToFile(MySet mySet, String path) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            mySet.stream().forEach(t -> {
                try {
                    writer.write(t.writeToFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
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
