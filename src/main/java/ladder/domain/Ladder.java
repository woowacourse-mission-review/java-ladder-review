package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<Line> {
    static final int LADDER_HEIGHT_MIN_BOUNDARY = 1;

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = new ArrayList<>(lines);
        validateHeight(this.lines);
        validateSameSizeOfDirections(this.lines);
    }

    public static Ladder of(final List<Line> lines) {
        return new Ladder(lines);
    }

    private void validateHeight(final List<Line> lines) {
        if (lines.size() < LADDER_HEIGHT_MIN_BOUNDARY) {
            throw new IllegalArgumentException(LADDER_HEIGHT_MIN_BOUNDARY + "이상이어야 합니다.");
        }
    }

    private void validateSameSizeOfDirections(final List<Line> lines) {
        Line line = lines.get(0);
        if (lines.stream().anyMatch(x -> !x.matchSize(line))) {
            throw new IllegalArgumentException("모든 Line의 Direction 개수가 일치하지 않습니다.");
        }
    }

    public Position moveUntilEnd(final Position startPosition) {
        Position position = startPosition;
        for (final Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    @Override
    public Iterator<Line> iterator() {
        return new Iterator<Line>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < lines.size();
            }

            @Override
            public Line next() {
                return lines.get(cursor++);
            }
        };
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
