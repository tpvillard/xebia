package com.biffbangpow.mowitnow;

/**
 * An abstract translation.
 */
public abstract class AbstractTranslation extends AbstractMove {

    private final Lawn lawn;

    AbstractTranslation(Mow mow, Lawn lawn) {

        super(mow);
        this.lawn = lawn;
    }

    protected abstract Position computeDestination();

    @Override
    public void execute() {

        Position destination = computeDestination();
        if (lawn.destinationPermitted(destination)) {
            mow.setPosition(destination);
        }
    }
}
