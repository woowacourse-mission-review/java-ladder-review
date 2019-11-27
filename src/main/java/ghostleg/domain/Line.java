package ghostleg.domain;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final ArrayList<Point> points;

    public Line(NumOfPlayers numOfPlayers, List<Point> points) {
        validateNumOfPoints(numOfPlayers, points);
        validateFirstAndLast(points);
        validateConsistency(points);
        this.points = Lists.newArrayList(points);
    }

    private void validateNumOfPoints(NumOfPlayers numOfPlayers, List<Point> points) {
        if (numOfPlayers.getValue() != points.size()) {
            throw new IllegalArgumentException("플레이어의 수와 포인트의 수가 일치해야 합니다.");
        }
    }

    private void validateFirstAndLast(List<Point> points) {
        Point first = points.get(0);
        Point last = points.get(points.size() - 1);
        if (!(first.isFirst() && last.isLast())) {
            throw new IllegalArgumentException("올바른 사다리 Line 이 아닙니다.");
        }
    }

    private void validateConsistency(List<Point> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            if (!points.get(i).canFollow(points.get(i+1))) {
                throw new IllegalArgumentException("사다리 Line 의 점들이 일관되지 않습니다.");
            }
        }
    }

    public Direction getNext(int index) {
        return points.get(index).move();
    }

    public List<Direction> getNextAll() {
        return points.stream()
                .map(Point::move)
                .collect(Collectors.toList());
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}
