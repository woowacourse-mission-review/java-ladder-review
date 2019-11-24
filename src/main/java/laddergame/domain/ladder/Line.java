package laddergame.domain.ladder;

import laddergame.domain.user.User;
import laddergame.domain.user.Users;

import java.util.List;

public class Line {

    private static final String NEW_LINE = "\n";
    private final List<Point> points;


    public Line(final List<Point> points) {
        this.points = points;
    }

    public void moveUsers(final Users users) {
        for (Point point : points) {
            point.moveUser(users);
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        points.forEach(stringBuilder::append);
        return stringBuilder.append(NEW_LINE).toString();
    }
}
