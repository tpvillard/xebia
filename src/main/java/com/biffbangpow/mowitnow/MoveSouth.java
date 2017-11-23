package com.biffbangpow.mowitnow;

/**
 * A move one cell in south direction.
 */
public class MoveSouth extends AbstractTranslation {

    public MoveSouth(Mow mow, Lawn lawn, Command cmd) {

        super(mow, lawn, cmd);
    }

    @Override
    protected Position computeDestination() {
        return new Position(mow.getPosition().getX(), mow.getPosition().getY() - 1);
    }
}
