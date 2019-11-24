package ghostleg;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Point> points;

    public Line(Point... points) {
        validateFirstAndLast(points);
        validateConsistency(points);
        this.points = Lists.newArrayList(points);
    }

    private void validateFirstAndLast(Point[] points) {
        Point first = points[0];
        Point last = points[points.length -1];
        if (!(first.isFirst() && last.isLast())) {
            throw new IllegalArgumentException("올바른 사다리 Line 이 아닙니다.");
        }
    }

    private void validateConsistency(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (!points[i].canFollow(points[i+1])) {
                throw new IllegalArgumentException("사다리 Line 의 점들이 일관되지 않습니다.");
            }
        }
    }

    public Direction getNext(int index) {
        return points.get(index).next();
    }
}
