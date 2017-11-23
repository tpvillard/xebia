package com.biffbangpow.mowitnow;

/**
 * An abstract move.
 */
public abstract class AbstractMove implements Move {

    protected final Mow mow;
    protected final Lawn lawn;
    protected final Command cmd;

    public AbstractMove(Mow mow, Lawn lawn, Command cmd) {
        this.mow = mow;
        this.lawn = lawn;
        this.cmd = cmd;
    }
}
