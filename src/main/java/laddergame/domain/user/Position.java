package laddergame.domain.user;

import laddergame.domain.user.exception.InvalidPositionException;

public class Position {

    public static final int MIN_POSITION = 0;
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
}
