package com.biffbangpow.mowitnow;

/**
 * A mow command.
 */
public enum Command {

    ROTATE_LEFT('G') {
        @Override
        boolean isRotation() {
            return true;
        }
    },
    ROTATE_RIGHT('D') {
        @Override
        boolean isRotation() {
            return true;
        }
    },
    TRANSLATION('A') {
        @Override
        boolean isRotation() {
            return false;
        }
    };

    private final char c;

    Command(char c) {
        this.c = c;
    }

    abstract boolean isRotation();

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
