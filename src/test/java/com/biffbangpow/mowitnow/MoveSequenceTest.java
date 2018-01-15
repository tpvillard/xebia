package com.biffbangpow.mowitnow;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MoveSequenceTest {

    @Test
    public void command_is_successfully_parsed() {
        List<Command> commands = MoveSequence.parseCommands("GAGAGAGAA");
        Assert.assertNotNull(commands);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void exception_raised_when_command_specification_in_error() {
        MoveSequence.parseCommands("ZZZZZZZZ");
    }
}
