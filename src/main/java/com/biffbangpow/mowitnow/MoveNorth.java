package com.biffbangpow.mowitnow;

/**
 * A move one cell in north direction.
 */
public class MoveNorth extends AbstractTranslation {

    public MoveNorth(Mow mow, Lawn lawn, Command cmd) {

        super(mow, lawn, cmd);
    }

    @Override
    protected Position computeDestination() {
        return new Position(mow.getPosition().getX(), mow.getPosition().getY() + 1);
    }
}
