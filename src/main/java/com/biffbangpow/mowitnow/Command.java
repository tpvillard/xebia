package com.biffbangpow.mowitnow;

/**
 * A mow command.
 */
public enum Command {

    ROTATE_LEFT('G'),
    ROTATE_RIGHT('D'),
    TRANSLATION('A');

    private final char c;

    Command(char c) {
        this.c = c;
    }

    private char getChar() {
        return c;
    }

    static Command of(char c) {
        Command.values();
        for (Command command : Command.values()) {
            if (command.getChar() == c) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid Command: " + c);
    }
}
