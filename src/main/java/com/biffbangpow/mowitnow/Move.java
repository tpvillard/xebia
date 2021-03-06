package com.biffbangpow.mowitnow;

/**
 * A move operation for a mow.
 */
public interface Move {

    /**
     * execute the move operation for the mow
     */
    void execute();

    /**
     * Creates a move.
     *
     * @param mow  the mow to move.
     * @param lawn the lawn
     * @return the move
     */
    static Move create(Mow mow, Command cmd, Lawn lawn) {
        Move move;
        switch (cmd) {
            case ROTATE_LEFT:
                move = new RotateAntiClockwise(mow);
                break;
            case ROTATE_RIGHT:
                move = new RotateClockwise(mow);
                break;

            case TRANSLATION:
                switch (mow.getOrientation()) {

                    case NORTH:
                        move = new MoveNorth(mow, lawn);
                        break;

                    case EAST:
                        move = new MoveEast(mow, lawn);
                        break;

                    case SOUTH:
                        move = new MoveSouth(mow, lawn);
                        break;

                    case WEST:
                        move = new MoveWest(mow, lawn);
                        break;
                    default:
                        throw new IllegalArgumentException("Orientation not supported: " + cmd);
                }
                break;
            default:
                throw new IllegalArgumentException("Command not supported: " + cmd);
        }
        return move;
    }
}
