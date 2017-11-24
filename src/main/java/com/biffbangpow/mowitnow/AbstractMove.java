package com.biffbangpow.mowitnow;

/**
 * An abstract move.
 */
public abstract class AbstractMove implements Move {

    protected final Mow mow;
    protected final Lawn lawn;

    public AbstractMove(Mow mow, Lawn lawn) {
        this.mow = mow;
        this.lawn = lawn;
    }
}
