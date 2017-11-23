package com.biffbangpow.mowitnow;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * The mow orientation
 */
public enum Orientation {

    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char c;

    Orientation(char c) {
        this.c = c;
    }

    public char getChar() {
        return c;
    }

    static Orientation of(char c) {
        Orientation.values();
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getChar() == c) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid Orientation: " + c);
    }

    public enum Transition {

        NORTH_EAST(NORTH, Command.ROTATE_RIGHT, EAST),
        NORTH_WEST(NORTH, Command.ROTATE_LEFT, WEST),

        EAST_SOUTH(EAST, Command.ROTATE_RIGHT, SOUTH),
        EAST_NORTH(EAST, Command.ROTATE_LEFT, NORTH),

        SOUTH_WEST(SOUTH, Command.ROTATE_RIGHT, WEST),
        SOUTH_EAST(SOUTH, Command.ROTATE_LEFT, EAST),

        WEST_NORTH(WEST, Command.ROTATE_RIGHT, NORTH),
        WEST_SOUTH(WEST, Command.ROTATE_LEFT, SOUTH);


        final Orientation source;
        final Command cmd;
        final Orientation dest;

        Transition(Orientation source, Command command, Orientation destination) {
            this.source = source;
            this.cmd = command;
            this.dest = destination;
        }
    }

    private static final Map<Orientation, Map<Command, Orientation>> map = new HashMap<>();
    static {
        for (Orientation orientation: Orientation.values()) {
            map.put(orientation, new EnumMap<>(Command.class));
        }
        for (Transition t: Transition.values()) {
            map.get(t.source).put(t.cmd, t.dest);
        }
    }

    public static Orientation get(Orientation source, Command cmd) {

        return map.get(source).get(cmd);
    }
}
