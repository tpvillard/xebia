package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CommandTest {

    @Test
    public void translate_char_to_command() {
        Assert.assertEquals(Command.of('A'), Command.TRANSLATION);
        Assert.assertEquals(Command.of('G'), Command.ROTATE_LEFT);
        Assert.assertEquals(Command.of('D'), Command.ROTATE_RIGHT);
    }

    @Test
    public void command_is_successfully_parsed() {
        List<Command> commands = MoveSequence.parseCommands("GAGAGAGAA");
        Assert.assertNotNull(commands);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void exception_raised_when_mow_parsing_fails() {
        MoveSequence.parseCommands("ZZZZZZZZ");
    }
}
