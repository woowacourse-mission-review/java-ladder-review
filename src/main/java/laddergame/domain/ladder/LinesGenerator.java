package laddergame.domain.ladder;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinesGenerator {

    private static final int NUM_OF_FIRST_AND_LAST = 2;
    private final int numOfUsers;
    private final Height height;

    public LinesGenerator(final int numOfUsers, final Height height) {
        this.numOfUsers = numOfUsers;
        this.height = height;
    }

    public Lines generateLines() {
        return new Lines(
            IntStream.rangeClosed(1, height.getHeight()).mapToObj(height -> generateLine())
                .collect(Collectors.toList()));
    }

    private Line generateLine() {
        Random random = new Random();
        boolean current = random.nextBoolean();
        Point point = Point.first(current);
        List<Point> line = Lists.newArrayList(point);
        int betweenFirstAndLast = this.numOfUsers - NUM_OF_FIRST_AND_LAST;

        for (int i = 0; i < betweenFirstAndLast; i++) {
            current = !current && random.nextBoolean();
            point = point.next(current);
            line.add(point);
        }
        line.add(point.last());
        return new Line(line);
    }
}
