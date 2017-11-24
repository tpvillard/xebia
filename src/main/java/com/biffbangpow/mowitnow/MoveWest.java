package com.biffbangpow.mowitnow;

/**
 * A move one cell in west direction.
 */
public class MoveWest extends AbstractTranslation {

    public MoveWest(Mow mow, Lawn lawn) {

        super(mow, lawn);
    }

    @Override
    protected Position computeDestination() {
        return new Position(mow.getPosition().getX() - 1, mow.getPosition().getY());
    }
}
