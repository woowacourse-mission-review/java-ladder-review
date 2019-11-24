package ghostleg;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Point> points;

    public Line(Point... points) {
        validateFirstAndLast(points);
        this.points = Lists.newArrayList(points);
    }

    private void validateFirstAndLast(Point[] points) {
        Point first = points[0];
        Point last = points[points.length -1];
        if (!(first.isFirst() && last.isLast())) {
            throw new IllegalArgumentException("올바른 사다리 Line 이 아닙니다.");
        }
    }

    public Direction getNext(int index) {
        return points.get(index).next();
    }
}
