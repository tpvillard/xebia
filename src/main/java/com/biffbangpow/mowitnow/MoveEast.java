package com.biffbangpow.mowitnow;

/**
 * A move one cell in east direction.
 */
public class MoveEast extends AbstractTranslation {

    public MoveEast(Mow mow, Lawn lawn) {

        super(mow, lawn);
    }

    @Override
    protected Position computeDestination() {
        return new Position(mow.getPosition().getX() + 1, mow.getPosition().getY());
    }
}
