package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LawnTest {

    private Lawn lawn = new Lawn(5, 5);

    @BeforeMethod
    public void setUp() {
        lawn.clear();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void exception_raised_when_mow_initial_position_is_invalid() {
        Mow mow = new Mow(new Position(6, 6), Orientation.SOUTH);
        lawn.add(mow);
    }

    @Test
    public void destination_not_permitted_when_cell_is_occupied() {
        Mow mow = new Mow(new Position(0, 0), Orientation.SOUTH);
        lawn.add(mow);
        Assert.assertFalse(lawn.destinationPermitted(new Position(0, 0)));
    }

    @Test
    public void destination_permitted_when_cell_is_free() {
        Mow mow = new Mow(new Position(0, 0), Orientation.SOUTH);
        lawn.add(mow);
        Assert.assertTrue(lawn.destinationPermitted(new Position(4, 4)));
    }

    @Test
    public void destination_not_permitted_when_y_is_out_of_bounds() {
        Assert.assertFalse(lawn.destinationPermitted(new Position(0, -1)));
        Assert.assertFalse(lawn.destinationPermitted(new Position(0, 6)));
    }

    @Test
    public void destination_not_permitted_when_x_is_out_of_bounds() {
        Assert.assertFalse(lawn.destinationPermitted(new Position(-1, 0)));
        Assert.assertFalse(lawn.destinationPermitted(new Position(6, 0)));
    }

    @Test
    public void lawn_successfully_created() {
        Lawn lawn = Lawn.parse("5 5");
        Assert.assertNotNull(lawn);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void exception_raised_when_lawn_not_correctly_specified() {
        Lawn.parse("A 5");
    }
}
