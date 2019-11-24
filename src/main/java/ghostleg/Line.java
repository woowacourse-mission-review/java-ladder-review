package ghostleg;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class Line {
    private final ArrayList<Point> points;

    public Line(Point... points) {
        this.points = Lists.newArrayList(points);
    }

    public Direction getNext(int index) {
        return points.get(index).next();
    }
}
