package com.biffbangpow.mowitnow;

import java.util.Arrays;

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
        return Arrays.stream(Command.values())
                .filter(command -> command.getChar() == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Command: " + c));
    }
}
