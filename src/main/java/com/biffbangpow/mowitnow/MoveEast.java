package com.biffbangpow.mowitnow;

/**
 * A move one cell in north direction.
 */
public class MoveEast extends AbstractTranslation {

    public MoveEast(Mow mow, Lawn lawn, Command cmd) {

        super(mow, lawn, cmd);
    }

    @Override
    protected Position computeDestination() {
        return new Position(mow.getPosition().getX() + 1, mow.getPosition().getY());
    }
}
