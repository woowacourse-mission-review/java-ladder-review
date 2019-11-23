package ladder.domain;

public enum Direction {
    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private final int direction;

    Direction(final int direction) {
        this.direction = direction;
    }

    public static Direction of(final boolean direction) {
        return direction ? RIGHT : STRAIGHT;
    }

    public Direction next(final boolean right) {
        if (this == RIGHT) {
            return LEFT;
        }
        return right ? RIGHT : STRAIGHT;
    }

    public Direction last() {
        if (this == RIGHT) {
            return LEFT;
        }
        return STRAIGHT;
    }

    public boolean isRight() {
        return this == RIGHT;
    }

    public int getDirection() {
        return direction;
    }
}
