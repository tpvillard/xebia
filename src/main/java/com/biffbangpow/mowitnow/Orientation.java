package com.biffbangpow.mowitnow;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static com.biffbangpow.mowitnow.Command.*;

/**
 * The mow orientation.
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
        return Arrays.stream(Orientation.values())
                .filter(orientation -> orientation.getChar() == c)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Orientation: " + c));
    }

    public enum Transition {

        NORTH_EAST(NORTH, ROTATE_RIGHT, EAST),
        NORTH_WEST(NORTH, ROTATE_LEFT, WEST),

        EAST_SOUTH(EAST, ROTATE_RIGHT, SOUTH),
        EAST_NORTH(EAST, ROTATE_LEFT, NORTH),

        SOUTH_WEST(SOUTH, ROTATE_RIGHT, WEST),
        SOUTH_EAST(SOUTH, ROTATE_LEFT, EAST),

        WEST_NORTH(WEST, ROTATE_RIGHT, NORTH),
        WEST_SOUTH(WEST, ROTATE_LEFT, SOUTH);


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
