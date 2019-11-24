package laddergame.domain.ladder;

import java.util.List;

public class Line {

    private static final String NEW_LINE = "\n";
    private final List<Point> points;

    public Line(final List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        points.forEach(stringBuilder::append);
        return stringBuilder.append(NEW_LINE).toString();
    }
}
