package laddergame.domain.ladder;

import laddergame.domain.ladder.exception.InvalidDirectionException;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        if (canMoveBothSides(left, right)) {
            throw new InvalidDirectionException();
        }
        this.left = left;
        this.right = right;
    }

    private boolean canMoveBothSides(final boolean left, final boolean right) {
        return left && right;
    }

    public static Direction of(final boolean left, final boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(final boolean right) {
        return Direction.of(false, right);
    }

    public Direction last() {
        return Direction.of(this.right, false);
    }

    public Direction next(final boolean right) {
        return Direction.of(this.right, right);
    }

    public boolean canMoveRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Direction{" +
            "left=" + left +
            ", right=" + right +
            '}';
    }
}
