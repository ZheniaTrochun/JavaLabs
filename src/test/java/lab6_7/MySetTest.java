package lab6_7;

import lab5.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenia on 05.06.17.
 */
public class MySetTest {

    private MySet set;


    @Before
    public void setUp(){
        List<Toy> list = new ArrayList<Toy>();
        list.add(new Ball());
        list.add(new Doll());
        list.add(new Cube());
        set = new MySet(list);
    }

    @Test
    public void testAdd(){
        Assert.assertTrue(set.add(new SmallCar()));
        Assert.assertEquals(4, set.size());

        Assert.assertFalse(set.add(new SmallCar()));
        Assert.assertEquals(4, set.size());
    }

    @Test
    public void testRemove(){
        Assert.assertTrue(set.remove(new Ball()));
        Assert.assertEquals(2, set.size());
        Assert.assertFalse(set.remove(new MediumCar()));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveNegative() {
        Assert.assertFalse(set.remove(null));
    }

    @Test
    public void testRemoveNegative2() {
        Assert.assertFalse(set.remove("error"));
    }

    @Test
    public void testClear(){
        Assert.assertEquals(3, set.size());
        set.clear();
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void testRemoveAll() {
        List<Toy> list = new ArrayList<Toy>();
        list.add(new SmallCar());

        Assert.assertFalse(set.removeAll(list));

        list.add(new Ball());
        Assert.assertEquals(3, set.size());

        Assert.assertTrue(set.removeAll(list));
        Assert.assertEquals(2, set.size());

        list.add(new Doll());
        list.add(new Cube());

        Assert.assertTrue(set.removeAll(list));
        Assert.assertEquals(0, set.size());
    }

    @Test
    public void testRetainAll() {
        List<Toy> list = new ArrayList<Toy>();
        list.add(new SmallCar());
        list.add(new Ball());
        list.add(new Doll());

        Assert.assertEquals(3, set.size());

        Assert.assertTrue(set.retainAll(list));
        Assert.assertEquals(2, set.size());

        list.clear();

        list.add(new Ball());
        list.add(new Doll());

        Assert.assertFalse(set.retainAll(list));
    }

    @Test
    public void testToArray() {
        Toy[] testArr = {new Ball(), new Doll(), new Cube()};

        Assert.assertEquals(testArr, set.toArray());
    }

    @Test
    public void testContains(){
        Assert.assertTrue(set.contains(new Doll()));
        Assert.assertFalse(set.contains(new SmallCar()));
    }
}
