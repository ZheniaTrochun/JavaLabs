package lab5;

import lab5.controller.GameRoom;
import lab5.exceptions.InvalidInputDataException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhenia on 06.06.17.
 */
public class lab5 {
    @Test
    public void testCreatingRoom() throws IllegalAccessException, InvalidInputDataException, InstantiationException {
        Assert.assertNotNull(new GameRoom(1000, 15));
    }

    @Test(expected = InvalidInputDataException.class)
    public void testCreatingRoomNegative() throws IllegalAccessException, InvalidInputDataException, InstantiationException {
        Assert.assertNotNull(new GameRoom(10, 150));
    }

    @Test(expected = InvalidInputDataException.class)
    public void testCreatingRoomNegative2() throws IllegalAccessException, InvalidInputDataException, InstantiationException {
        Assert.assertNotNull(new GameRoom(10, 0));
    }

    @Test
    public void testFindByRange() throws Exception {
        Assert.assertNotNull(new GameRoom(1000, 15).findGameByPriceDiapasone(10, 100));
        Assert.assertNull(new GameRoom(1000, 15).findGameByPriceDiapasone(200, 300));
    }
}
