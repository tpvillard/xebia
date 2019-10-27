package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class MainTest {

    @Test
    public void run() {

        String[] spec = {"5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA" };
        Main main = Main.of(spec);
        main.run();
        List<Mow> mows = main.getMows();
        Assert.assertTrue(mows.contains(Mow.parse("1 3 N")));
        Assert.assertTrue(mows.contains(Mow.parse("5 1 E")));
    }
}
