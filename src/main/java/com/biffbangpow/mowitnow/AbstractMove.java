package com.biffbangpow.mowitnow;

/**
 * An abstract move.
 */
public abstract class AbstractMove implements Move {

    protected final Mow mow;

    public AbstractMove(Mow mow) {
        this.mow = mow;
    }
}
