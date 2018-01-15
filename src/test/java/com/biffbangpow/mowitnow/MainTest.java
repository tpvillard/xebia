package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class MainTest {

    @Test
    public void run() {

        String[] spec = {"5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA" };
        Main main = Main.of(spec);
        main.run();
        Set<Mow> mows = main.getMow();
        Assert.assertTrue(mows.contains(Mow.parse("1 3 N")));
        Assert.assertTrue(mows.contains(Mow.parse("5 1 E")));
    }
}
