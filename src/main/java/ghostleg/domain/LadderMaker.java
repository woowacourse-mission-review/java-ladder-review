package ghostleg.domain;

import com.google.common.collect.Lists;

import java.util.List;

public class LadderMaker {
    public static Ladder newInstance(NumOfPlayers numOfPlayers, LadderHeight ladderHeight) {
        return new Ladder(ladderHeight, createLines(numOfPlayers, ladderHeight));
    }

    private static List<Line> createLines(NumOfPlayers numOfPlayers, LadderHeight height) {
        List<Line> lines = Lists.newArrayList();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new Line(numOfPlayers, createRandomPoints(numOfPlayers)));
        }
        return lines;
    }

    private static List<Point> createRandomPoints(NumOfPlayers numOfPoints) {
        List<Point> points =  Lists.newArrayList();
        Point first = Point.first(getRandomBoolean());
        Point tmp = first;
        points.add(first);
        for (int i = 0; i < numOfPoints.getValue() - 2; i++) {
            tmp = tmp.next(getRandomBoolean());
            points.add(tmp);
        }
        points.add(tmp.last());
        return points;
    }

    private static boolean getRandomBoolean() {
        return (int) (Math.random() * 2) == 0;
    }
}
