package com.biffbangpow.mowitnow;

/**
 * A single move operation for a mow
 */
public interface Move {

    /**
     * execute the move operation for the mow
     */
    void execute();

    /**
     * Create a move.
     * @param mow the mow to move.
     * @param cmd the command used.
     * @param lawn the lawn
     * @return the move
     */
    static Move create(Mow mow, Command cmd, Lawn lawn) {
        Move move;
        switch (cmd) {
            case ROTATE_LEFT:
            case ROTATE_RIGHT:
                move = new Rotation(mow, lawn, cmd);
                break;

            case TRANSLATION:
                switch (mow.getOrientation()) {

                    case NORTH:
                        move = new MoveNorth(mow, lawn, cmd);
                        break;

                    case EAST:
                        move = new MoveEast(mow, lawn, cmd);
                        break;

                    case SOUTH:
                        move = new MoveSouth(mow, lawn, cmd);
                        break;

                    case WEST:
                        move = new MoveWest(mow, lawn, cmd);
                        break;
                    default:
                        throw new IllegalArgumentException("Orientation not supported: "+ cmd);
                }
                break;
            default:
                throw new IllegalArgumentException("Command not supported: "+ cmd);
        }
        return move;
    }
}
