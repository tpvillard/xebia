package com.biffbangpow.mowitnow;

/**
 * A rotation.
 */
public class RotateClockwise extends AbstractMove {

    public RotateClockwise(Mow mow) {
        super(mow);

    }

    @Override
    public void execute() {

        mow.setOrientation(Orientation.get(mow.getOrientation(), Command.ROTATE_RIGHT));
    }
}
