package com.biffbangpow.mowitnow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Main entry point for the mowitnow application.
 */
public class Main {

    private final Lawn lawn;
    private final List<MoveSequence> moves;

    private Main(List<MoveSequence> moves, Lawn lawn) {
        this.moves = moves;
        this.lawn = lawn;
    }

    public void run() {

        for (MoveSequence sequence : moves) {
            sequence.execute(lawn);
        }
    }

    public static void main(String[] args) {

        Main main = of(args);
        main.run();
    }

    static Main of(String[] args) {

        Lawn lawn = Lawn.parse(args[0]);
        List<MoveSequence> moves = new ArrayList<>();
        for (int i = 1; i < args.length; i = i + 2) {
            moves.add(MoveSequence.parse(args[i], args[i + 1]));
        }

        // add all mow to the lawn
        for (MoveSequence sequence: moves) {
            lawn.add(sequence.getMow());
        }
        return new Main(moves, lawn);
    }


    public List<Mow> getMows() {
        return moves.stream().map(MoveSequence::getMow).collect(Collectors.toList());
    }
}
