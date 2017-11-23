package com.biffbangpow.mowitnow;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A move sequence for a mow.
 */
public class MoveSequence {

    private final Mow mow;
    private final List<Command> commands;

    public MoveSequence(Mow mow, List<Command> commands) {
        this.mow = mow;
        this.commands = commands;
    }

    Mow getMow() {
        return mow;
    }

    /**
     * Executes a move sequence.
     */
    public void execute(Lawn lawn) {

        for (Command cmd : commands) {

            Move.create(mow, cmd, lawn).execute();
        }
    }

    static MoveSequence parse(String mowInput, String commandInput) {

        Mow mow = Mow.parse(mowInput);
        List<Command> commands = parseCommands(commandInput);
        return new MoveSequence(mow, commands);
    }

    static List<Command> parseCommands(String commandInput) {
        List<Command> commands = new ArrayList<>();
        char[] charArray = commandInput.toCharArray();
        for (char c : charArray) {
            commands.add(Command.of(c));
        }
        return commands;
    }
}
