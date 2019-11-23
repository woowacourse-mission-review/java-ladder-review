package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadderFactory implements LadderFactory {
    private final Random random = new Random();

    @Override
    public Ladder create(final Height height, final int countOfPlayers) {
        List<Line> lines = IntStream.range(0, height.get())
                .mapToObj(x -> createLine(countOfPlayers))
                .collect(Collectors.toList());

        return Ladder.of(lines);
    }

    private Line createLine(final int countOfPlayers) {
        List<Direction> directions = new ArrayList<>();

        Direction direction = Direction.of(random.nextBoolean());
        directions.add(direction);
        for (int i = 1; i < countOfPlayers - 1; i++) {
            direction = direction.next(random.nextBoolean());
            directions.add(direction);
        }
        directions.add(direction.last());
        return Line.of(directions);
    }
}
