package ghostleg;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(boolean left, boolean right) {
        validateNoConsecutiveBridge(left, right);
        this.left = left;
        this.right = right;
    }

    public Direction next() {
        return Direction.of(left, right);
    }

    private void validateNoConsecutiveBridge(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양 쪽에 다리가 놓여있을 수 없습니다.");
        }
    }
}
