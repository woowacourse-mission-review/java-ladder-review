package laddergame.domain.ladder;

import laddergame.exception.LadderResultIndexNotFoundException;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class LadderLine {

    private static final String UNIT_STRING_OF_CROSS_BAR = "-";
    private static final String UNIT_STRING_OF_EMPTY_CROSS_BAR = " ";
    private static final String UNIT_STRING_OF_VERTICAL_LADDER_BAR = "|";

    private final List<Direction> directions;

    private LadderLine(final List<Direction> directions) {
        this.directions = directions;
    }

    public static LadderLine of(LadderCreationStrategy strategy, int width) {
        List<Direction> directions = new ArrayList<>();

        Direction currentDirection = null;
        for (int index = 1; index <= width; index++) {
            currentDirection = generateNextDirection(currentDirection, strategy, width - index);
            directions.add(currentDirection);
        }
        return new LadderLine(directions);
    }

    private static Direction generateNextDirection
            (final Direction currentDirection, final LadderCreationStrategy strategy, final int remaining) {
        if (Objects.isNull(currentDirection)) {
            return Direction.getFirst(strategy.createCrossBar());
        }

        if (remaining == 0) {
            return Direction.getLast(currentDirection.hasRight());
        }

        return currentDirection.decideNext(strategy);
    }

    public String getStringOfLadderLine(final int widthOfCrossBar) {
        String crossBar = StringUtils.repeat(UNIT_STRING_OF_CROSS_BAR, widthOfCrossBar);
        String emptyCrossBar = StringUtils.repeat(UNIT_STRING_OF_EMPTY_CROSS_BAR, widthOfCrossBar);

        StringJoiner stringJoiner = new StringJoiner(UNIT_STRING_OF_VERTICAL_LADDER_BAR
                , UNIT_STRING_OF_VERTICAL_LADDER_BAR, UNIT_STRING_OF_VERTICAL_LADDER_BAR);
        for (Direction direction : directions.subList(1, directions.size())) {
            stringJoiner.add(direction.hasLeft() ? crossBar : emptyCrossBar);
        }

        return stringJoiner.toString();
    }

    public List<Integer> moveToNextIndex(List<Integer> indices) {
        if (isNotSameSizeWithDirections(indices)) {
            throw new LadderResultIndexNotFoundException();
        }

        return indices.stream()
                .map(index -> {
                    Direction direction = directions.get(index);
                    return direction.moveToNextIndex(index);
                })
                .collect(Collectors.toList());
    }

    private boolean isNotSameSizeWithDirections(final List<Integer> indices) {
        return indices.size() != directions.size();
    }

    public int size() {
        return directions.size();
    }
}
