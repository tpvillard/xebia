package com.biffbangpow.mowitnow;


import org.testng.Assert;
import org.testng.annotations.Test;

public class OrientationTest {

    @Test
    public void rotation_map() {

        Assert.assertEquals(Orientation.EAST, Orientation.get(Orientation.NORTH, Command.ROTATE_RIGHT));
        Assert.assertEquals(Orientation.WEST, Orientation.get(Orientation.NORTH, Command.ROTATE_LEFT));
        Assert.assertEquals(Orientation.SOUTH, Orientation.get(Orientation.EAST, Command.ROTATE_RIGHT));
        Assert.assertEquals(Orientation.NORTH, Orientation.get(Orientation.EAST, Command.ROTATE_LEFT));
        Assert.assertEquals(Orientation.WEST, Orientation.get(Orientation.SOUTH, Command.ROTATE_RIGHT));
        Assert.assertEquals(Orientation.EAST, Orientation.get(Orientation.SOUTH, Command.ROTATE_LEFT));
        Assert.assertEquals(Orientation.NORTH, Orientation.get(Orientation.WEST, Command.ROTATE_RIGHT));
        Assert.assertEquals(Orientation.SOUTH, Orientation.get(Orientation.WEST, Command.ROTATE_LEFT));
    }
}
