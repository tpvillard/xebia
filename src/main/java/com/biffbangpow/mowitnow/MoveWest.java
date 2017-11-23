package com.biffbangpow.mowitnow;

/**
 * A move one cell in north direction.
 */
public class MoveWest extends AbstractTranslation {

    public MoveWest(Mow mow, Lawn lawn, Command cmd) {

        super(mow, lawn, cmd);
    }

    @Override
    protected Position computeDestination() {
        return new Position(mow.getPosition().getX() - 1, mow.getPosition().getY());
    }
}
