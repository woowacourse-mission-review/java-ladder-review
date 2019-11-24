package laddergame.domain.ladder;

import laddergame.exception.IllegalDirectionFoundException;

public enum Direction {

    LEFT(true, false),
    RIGHT(false, true),
    NONE(false, false);

    private boolean leftCrossBar;
    private boolean rightCrossBar;

    Direction(final boolean leftCrossBar, final boolean rightCrossBar) {
        this.leftCrossBar = leftCrossBar;
        this.rightCrossBar = rightCrossBar;
    }

    public static Direction getFirst(final boolean rightCrossBar) {
        return valueOf(false, rightCrossBar);
    }

    public static Direction getLast(final boolean leftCrossBar) {
        return valueOf(leftCrossBar, false);
    }

    public static Direction valueOf(final boolean leftCrossBar, final boolean rightCrossBar) {
        if (leftCrossBar && rightCrossBar) {
            throw new IllegalDirectionFoundException();
        }

        return (leftCrossBar || rightCrossBar) ? decideLeftOrRight(leftCrossBar) : NONE;
    }

    private static Direction decideLeftOrRight(final boolean leftCrossBar) {
        return leftCrossBar ? LEFT : RIGHT;
    }

    public Direction decideNext(final LadderCreationStrategy strategy) {
        return rightCrossBar ? LEFT : Direction.valueOf(false, strategy.createCrossBar());
    }

    public int moveToNextIndex(int index) {
        return (leftCrossBar || rightCrossBar) ? moveLeftOrRight(index) : index;
    }

    private int moveLeftOrRight(int index) {
        return leftCrossBar ? --index : ++index;
    }

    public boolean hasLeft() {
        return leftCrossBar;
    }

    public boolean hasRight() {
        return rightCrossBar;
    }
}
