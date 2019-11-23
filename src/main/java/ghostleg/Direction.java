package ghostleg;

public enum Direction {
    LEFT(-1),
    STRAIGHT(0),
    RIGHT(1);

    private final int move;

    Direction(int move) {
        this.move = move;
    }

    public static Direction of(boolean left, boolean right) {
        if (left) {
            return LEFT;
        }

        if (right) {
            return RIGHT;
        }

        return STRAIGHT;
    }

    public int next() {
        return move;
    }
}
