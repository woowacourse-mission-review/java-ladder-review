package ghostleg.domain;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final ArrayList<Point> points;

    public Line(NumOfPlayers numOfPlayers, Point... points) {
        validateNumOfPoints(numOfPlayers, points);
        validateFirstAndLast(points);
        validateConsistency(points);
        this.points = Lists.newArrayList(points);
    }

    private void validateNumOfPoints(NumOfPlayers numOfPlayers, Point[] points) {
        if (numOfPlayers.getValue() != points.length) {
            throw new IllegalArgumentException("플레이어의 수와 포인트의 수가 일치해야 합니다.");
        }
    }

    private void validateFirstAndLast(Point[] points) {
        Point first = points[0];
        Point last = points[points.length - 1];
        if (!(first.isFirst() && last.isLast())) {
            throw new IllegalArgumentException("올바른 사다리 Line 이 아닙니다.");
        }
    }

    private void validateConsistency(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (!points[i].canFollow(points[i + 1])) {
                throw new IllegalArgumentException("사다리 Line 의 점들이 일관되지 않습니다.");
            }
        }
    }

    public Direction getNext(int index) {
        return points.get(index).next();
    }

    public List<Direction> getNextAll() {
        return points.stream()
                .map(Point::next)
                .collect(Collectors.toList());
    }
}
