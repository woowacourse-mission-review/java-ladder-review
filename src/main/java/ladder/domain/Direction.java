package ladder.domain;

public enum Direction {
    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private final int direction;

    Direction(final int direction) {
        this.direction = direction;
    }

    public Direction next(final boolean right) {
        if (this == RIGHT) {
            return LEFT;
        }
        return right ? RIGHT : STRAIGHT;
    }

    public int getDirection() {
        return direction;
    }
}
