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
        // TODO: 원시값을 포장할 필요가 있지 않을까? (Direction 이라는 enum 클래스는 어떨까?) 이를 통해 if 문을 줄일 수도 있지 않을까?
        return Direction.of(left, right);
    }

    private void validateNoConsecutiveBridge(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양 쪽에 다리가 놓여있을 수 없습니다.");
        }
    }
}
