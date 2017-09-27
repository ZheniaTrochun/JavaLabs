package lab8;

import lab5.model.*;
import lab6_7.MySet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zhenia on 20.09.17.
 */
public class SerializatorTest {
    private MySet mySet;

    @Before
    public void setUp() {
        mySet = new MySet();

        mySet.add(new Ball("BallName", 12.0, "red", 10));
        mySet.add(new SmallCar("SmallCarName", 13.0, "green", 11));
        mySet.add(new MediumCar("MediumCarName", 13.0, "green", 11));
        mySet.add(new BigCar("BigCarName", 13.0, "green", 11));
        mySet.add(new Cube("CubeName", 14.0, "blue"));
        mySet.add(new Doll("DollName", 15.0, "violet"));
    }

    @Test
    public void humanReadableSerializationTest() throws IOException {
        ToySerializator.writeSet(mySet, "testFile.txt");
        MySet set = ToySerializator.readSet("testFile.txt");

        Assert.assertTrue(set.containsAll(mySet) && set.size() == mySet.size());
    }

    @Test
    public void readSetTest() {
        MySet set = ToySerializator.readSet("testFile.txt");
    }


    @Test
    public void writeSetTest() {
        ToySerializator.writeSet(mySet, "testFile.txt");
    }

    @Test
    public void oneByOneSerializationTest() throws IOException, ClassNotFoundException {
        ToySerializator.writeSetByElements(mySet, "testFile1.txt");
        MySet set = ToySerializator.readSetByElements("testFile1.txt");

        Assert.assertTrue(set.containsAll(mySet) && set.size() == mySet.size());
    }

    @Test
    public void standardSerializationTest() throws IOException, ClassNotFoundException {
        ToySerializator.writeSetBin(mySet, "testFile2.txt");
        MySet set = ToySerializator.readSetBin("testFile2.txt");

        Assert.assertTrue(set.containsAll(mySet) && set.size() == mySet.size());
    }
}
