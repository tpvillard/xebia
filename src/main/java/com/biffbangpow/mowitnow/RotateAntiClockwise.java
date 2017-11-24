package com.biffbangpow.mowitnow;

/**
 * A rotation.
 */
public class RotateAntiClockwise extends AbstractMove {

    public RotateAntiClockwise(Mow mow) {
        super(mow);

    }

    @Override
    public void execute() {

        mow.setOrientation(Orientation.get(mow.getOrientation(), Command.ROTATE_LEFT));
    }
}
