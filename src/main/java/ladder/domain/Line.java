package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_BOUNDARY_DIRECTIONS = 2;

    private final List<Direction> directions;

    private Line(final List<Direction> directions) {
        this.directions = new ArrayList<>(directions);
        validateDirections(this.directions);
    }

    private void validateDirections(final List<Direction> directions) {
        validateSize(directions);
        validateFirstDirection(directions);
        validateConnectedDirection(directions);
        validateLastDirection(directions);
    }

    public static Line of(final List<Direction> directions) {
        return new Line(directions);
    }

    private void validateSize(final List<Direction> directions) {
        if (directions.size() < MIN_BOUNDARY_DIRECTIONS) {
            throw new IllegalArgumentException("방향은 최소 " + MIN_BOUNDARY_DIRECTIONS + "개 이상이어야 합니다");
        }
    }

    private void validateFirstDirection(final List<Direction> directions) {
        if (directions.get(0) == Direction.LEFT) {
            throw new IllegalArgumentException("첫번째 방향은 왼쪽 방향일 수가 없습니다.");
        }
    }

    private void validateConnectedDirection(final List<Direction> directions) {
        for (int i = 0; i < directions.size() - 1; i++) {
            final Direction current = directions.get(i);
            final Direction next = directions.get(i + 1);

            if (isValidConnected(current, next)) {
                throw new IllegalArgumentException(String.format("방향이 일치하지 않습니다. (%s, %s)", current, next));
            }
        }
    }

    private boolean isValidConnected(final Direction current, final Direction next) {
        return (current == Direction.RIGHT && next != Direction.LEFT)
                || (current == Direction.LEFT && next == Direction.LEFT)
                || (current == Direction.STRAIGHT && next == Direction.LEFT);
    }

    private void validateLastDirection(final List<Direction> directions) {
        if (directions.get(directions.size() - 1) == Direction.RIGHT) {
            throw new IllegalArgumentException("마지막 방향은 왼쪽 방향일 수가 없습니다.");
        }
    }

    public Position move(final Position position) {
        final Direction direction = directions.get(position.get());
        return position.change(direction.getDirection());
    }
}
