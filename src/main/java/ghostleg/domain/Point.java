package ghostleg.domain;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        validateNoConsecutiveBridge(left, right);
        this.left = left;
        this.right = right;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point next(boolean right) {
        if (this.right && right) {
            right = false;
        }
        return new Point(this.right, right);
    }

    public Point last() {
        return new Point(this.right, false);
    }

    public Direction move() {
        return Direction.of(left, right);
    }

    private void validateNoConsecutiveBridge(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양 쪽에 다리가 놓여있을 수 없습니다.");
        }
    }

    public boolean isFirst() {
        return !left;
    }

    public boolean isLast() {
        return !right;
    }

    public boolean canFollow(Point another) {
        return this.right == another.left;
    }
}
