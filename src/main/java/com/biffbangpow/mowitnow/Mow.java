package com.biffbangpow.mowitnow;

/**
 * A mow.
 */
public class Mow {

    private Position position;
    private Orientation orientation;

    public Mow(Position position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     * Builds a mow from a String specification
     * @param input the input string
     * @return the Mow
     * @throws IllegalArgumentException when the specification is invalid
     */
    public static Mow parse(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Specification can't be null");
        }

        String[] arr = input.split(" ");
        if (arr.length != 3) {
            throw new IllegalArgumentException("Invalid Mow Specification " + input);
        }

        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);

        if (arr[2].length() > 1) {
            throw new IllegalArgumentException("Invalid Orientation Specification " + input);
        }
        Orientation orientation = Orientation.of(arr[2].charAt(0));
        return new Mow(new Position(x,y), orientation);
    }

    @Override
    public String toString() {
        return "Mow{" + position + " " + orientation.getChar() +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mow mow = (Mow) o;

        return (position != null ? position.equals(mow.position) : mow.position == null) && orientation == mow.orientation;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        return result;
    }
}
