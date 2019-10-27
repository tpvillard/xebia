package com.biffbangpow.mowitnow;

import java.util.ArrayList;
import java.util.List;

/**
 * A lawn.
 */
public class Lawn {

    private final int x_length;
    private final int y_length;
    private final List<Mow> mows;

    /**
     * Creates the lawn.
     * @param x_length size of the lawn along the x axis
     * @param y_length size of the lawn along the y axis
     */
    public Lawn(int x_length, int y_length) {
        this.x_length = x_length;
        this.y_length = y_length;
        mows = new ArrayList<>();
    }

    /**
     * add the mow in the lawn.
     * @param mow the mow
     * @throws IllegalArgumentException is initial position of the mow is already occupied or out of bounds.
     */
    public void add(Mow mow) {

        Position position = mow.getPosition();
        if (position.getX() > x_length || position.getY() > y_length) {
            throw new IllegalArgumentException("Mow position is out of lawn bounds: " + mow.getPosition());
        }

        if (isOccupied(mow.getPosition())) {
            throw new IllegalArgumentException("Initial position for the mow is occupied: " + mow.getPosition());
        }
        mows.add(mow);
    }

    /**
     * Check whether the destination position is permitted.
     *
     * @param p the destination position
     * @return true when permitted
     */
    public boolean destinationPermitted(Position p) {

        return (p.getX() >= 0 && p.getX() < x_length + 1 && p.getY() >= 0 &&
                p.getY() < y_length + 1 && !isOccupied(p));
    }

    private boolean isOccupied(Position p) {
        return mows.stream().anyMatch(mow -> mow.getPosition().equals(p));
    }

    /**
     * Builds a lawn from a string specification.
     * @param input the input string
     * @return the lawn
     * @throws IllegalArgumentException if specification is invalid
     */
    public static Lawn parse(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Specification can't be null");
        }

        String[] arr = input.split(" ");
        if (arr.length != 2) {
            throw new IllegalArgumentException("Invalid Lawn Specification " + input);
        }

        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);
        return new Lawn(x, y);
    }

    public void clear() {
        mows.clear();
    }
}
