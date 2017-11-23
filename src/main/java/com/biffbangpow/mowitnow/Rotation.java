package com.biffbangpow.mowitnow;

/**
 * A rotation
 */
public class Rotation extends AbstractMove {

    public Rotation(Mow mow, Lawn lawn, Command cmd) {
        super(mow, lawn, cmd);

    }

    @Override
    public void execute() {

        mow.setOrientation(Orientation.get(mow.getOrientation(), cmd));
    }
}
