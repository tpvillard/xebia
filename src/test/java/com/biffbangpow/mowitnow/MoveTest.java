package com.biffbangpow.mowitnow;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MoveTest {

    private Position source = new Position(2, 2);
    private Mow mow = new Mow(source, Orientation.NORTH);
    private Lawn lawn = new Lawn(5, 5);

    @BeforeMethod
    public void setUp() {
        lawn.clear();
        mow.setOrientation(Orientation.NORTH);
        mow.setPosition(source);
        lawn.add(mow);
    }

    @Test
    public void mow_rotate_clockwise() {

        RotateClockwise move = new RotateClockwise(mow);
        move.execute();
        Assert.assertEquals(mow.getOrientation(), Orientation.EAST);
    }

    @Test
    public void mow_rotate_anticlockwise() {

        RotateAntiClockwise move = new RotateAntiClockwise(mow);
        move.execute();
        Assert.assertEquals(mow.getOrientation(), Orientation.WEST);
    }

    @Test
    public void mow_moves_north() {

        mow.setOrientation(Orientation.NORTH);
        Position destination = new Position(2, 3);
        MoveNorth move = new MoveNorth(mow, lawn);
        executeAndVerify(move, source, destination);
    }

    @Test
    public void mow_moves_east() {

        mow.setOrientation(Orientation.EAST);
        Position destination = new Position(3, 2);
        MoveEast move = new MoveEast(mow, lawn);
        executeAndVerify(move, source, destination);
    }

    @Test
    public void mow_moves_south() {

        mow.setOrientation(Orientation.SOUTH);
        Position destination = new Position(2, 1);
        MoveSouth move = new MoveSouth(mow, lawn);
        executeAndVerify(move, source, destination);
    }

    @Test
    public void mow_moves_west() {

        mow.setOrientation(Orientation.WEST);
        Position destination = new Position(1, 2);
        MoveWest move = new MoveWest(mow, lawn);
        executeAndVerify(move, source, destination);
    }

    private void executeAndVerify(Move move, Position source, Position destination) {
        move.execute();
        Assert.assertEquals(mow.getPosition(), destination);
        Assert.assertTrue(lawn.destinationPermitted(source));
        Assert.assertFalse(lawn.destinationPermitted(destination));
    }

    @Test
    public void mow_does_not_move_when_destination_is_not_permitted() {

        Position position = new Position(5, 5);
        mow.setPosition(position);

        mow.setOrientation(Orientation.EAST);
        MoveEast moveEast = new MoveEast(mow, lawn);
        verifyDidNotMove(moveEast, position);

        mow.setOrientation(Orientation.NORTH);
        MoveNorth moveNorth = new MoveNorth(mow, lawn);
        verifyDidNotMove(moveNorth, position);

        position = new Position(0, 0);
        mow.setPosition(position);
        mow.setOrientation(Orientation.SOUTH);
        MoveSouth moveSouth = new MoveSouth(mow, lawn);
        verifyDidNotMove(moveSouth, position);

        mow.setOrientation(Orientation.WEST);
        MoveWest moveWest = new MoveWest(mow, lawn);
        verifyDidNotMove(moveWest, position);
    }

    private void verifyDidNotMove(Move move, Position position) {
        move.execute();
        Assert.assertEquals(mow.getPosition(), position);
    }
}
