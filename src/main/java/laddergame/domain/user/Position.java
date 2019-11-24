package laddergame.domain.user;

import laddergame.domain.user.exception.InvalidPositionException;

import java.util.Objects;

public class Position {

    public static final int MIN_POSITION = 0;
    public static final int FOR_NEXT_POSITION = 1;
    public static final int FIRST_POSITION = 0;
    private int position;

    private Position(final int position) {
        if (position < MIN_POSITION) {
            throw new InvalidPositionException();
        }
        this.position = position;
    }

    public static Position of(final int position) {
        return new Position(position);
    }

    public Position next() {
        return Position.of(this.position + FOR_NEXT_POSITION);
    }

    public void move(final int moveValue) {
        position += moveValue;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    public boolean isFirst() {
        return this.position == FIRST_POSITION;
    }

    public void moveRight() {
        this.position++;
    }

    public void moveLeft() {
        this.position--;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "position: " + position;
    }
}
