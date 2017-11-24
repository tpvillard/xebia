package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CommandTest {

    @Test
    public void test_char_to_command() {
        Assert.assertEquals(Command.of('A'), Command.TRANSLATION);
        Assert.assertEquals(Command.of('G'), Command.ROTATE_LEFT);
        Assert.assertEquals(Command.of('D'), Command.ROTATE_RIGHT);
    }

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
