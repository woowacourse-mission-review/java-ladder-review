package laddergame.domain.ladder;

import laddergame.domain.user.Position;
import laddergame.domain.user.User;
import laddergame.domain.user.Users;

public class Point {

    private final Position position;
    private final Direction direction;

    public Point(final Position position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(final boolean right) {
        return new Point(Position.of(0), Direction.first(right));
    }

    public Point next(final boolean right) {
        return new Point(this.position.next(), direction.next(right));
    }

    public Point last() {
        return new Point(this.position.next(), direction.last());
    }

    public boolean isFirst() {
        return position.isFirst();
    }

    public void moveUser(final Users users) {
        if (direction.canMoveRight()) {
            User leftUser = users.getUserOf(position);
            User rightUser = users.getUserOf(position.next());
            leftUser.moveRight();
            rightUser.moveLeft();
        }
    }

    public boolean canMoveRight() {
        return direction.canMoveRight();
    }

    @Override
    public String toString() {
        return "Point{" +
            "position=" + position +
            ", direction=" + direction +
            '}';
    }
}
