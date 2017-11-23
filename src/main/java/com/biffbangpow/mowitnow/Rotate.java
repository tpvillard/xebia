package com.biffbangpow.mowitnow;

/**
 * A rotation
 */
public class Rotate extends AbstractMove {

    public Rotate(Mow mow, Lawn lawn, Command cmd) {
        super(mow, lawn, cmd);

    }

    @Override
    public void execute() {

        mow.setOrientation(Orientation.get(mow.getOrientation(), cmd));
    }
}
