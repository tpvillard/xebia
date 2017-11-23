package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MowTest {

    @Test
    public void test_mow_is_parsed() {
        Mow mow = Mow.parse("1 2 N");
        Assert.assertNotNull(mow);
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void test_mow_parsing_fails() {
        Mow.parse("A 6 S");
    }
}
