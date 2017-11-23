package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LawnTest {

    private Lawn lawn = new Lawn(5, 5);

    @BeforeMethod
    public void setup() {
        lawn.clear();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void test_mow_initial_position_is_invalid() {
        Mow mow = new Mow(new Position(6, 6), Orientation.SOUTH);
        lawn.add(mow);
    }

    @Test
    public void test_cell_is_occupied() {
        Mow mow = new Mow(new Position(0, 0), Orientation.SOUTH);
        lawn.add(mow);
        Assert.assertFalse(lawn.destinationPermitted(new Position(0, 0)));
    }

    @Test
    public void test_cell_is_free() {
        Mow mow = new Mow(new Position(0, 0), Orientation.SOUTH);
        lawn.add(mow);
        Assert.assertTrue(lawn.destinationPermitted(new Position(4, 4)));
    }

    @Test
    public void test_position_is_out_of_bounds_along_y() {
        Assert.assertFalse(lawn.destinationPermitted(new Position(0, -1)));
        Assert.assertFalse(lawn.destinationPermitted(new Position(0, 6)));
    }

    @Test
    public void test_position_is_out_of_bounds_along_x() {
        Assert.assertFalse(lawn.destinationPermitted(new Position(-1, 0)));
        Assert.assertFalse(lawn.destinationPermitted(new Position(6, 0)));
    }

    @Test
    public void test_lawn_is_parsed() {
        Lawn lawn = Lawn.parse("5 5");
        Assert.assertNotNull(lawn);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void test_lawn_parsing_fails() {
        Lawn.parse("A 5");
    }
}
