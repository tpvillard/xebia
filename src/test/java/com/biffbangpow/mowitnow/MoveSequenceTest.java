package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MoveSequenceTest {

    @Test
    public void test_command_is_parsed() {
        List<Command> commands = MoveSequence.parseCommands("GAGAGAGAA");
        Assert.assertNotNull(commands);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void test_mow_parsing_fails() {
        MoveSequence.parseCommands("ZZZZZZZZ");
    }
}
