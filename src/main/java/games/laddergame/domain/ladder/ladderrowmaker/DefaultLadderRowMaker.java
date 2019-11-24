package games.laddergame.domain.ladder.ladderrowmaker;

import games.laddergame.domain.ladder.MeetingPoint;
import games.laddergame.domain.ladder.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLadderRowMaker implements LadderRowMaker {
    private int width;
    private List<Boolean> previousValues;
    private Random random = new Random();

    public DefaultLadderRowMaker(int width) {
        this.width = width - 1;
    }

    @Override
    public Row createRow() {
        previousValues = new ArrayList<>();
        List<MeetingPoint> row = IntStream.rangeClosed(1, width)
                .mapToObj(index -> createOneMeetingPoint(index))
                .collect(Collectors.toList());

        System.out.println(row);
        return new Row(row);
    }

    private MeetingPoint createOneMeetingPoint(int index) {
        boolean currentValue = random.nextBoolean();
        if (previousValues.isEmpty()) {
            previousValues.add(currentValue);
            return new MeetingPoint(index, currentValue);
        }
        if (previousValues.get(previousValues.size() - 1)) {
            currentValue = false;
        }
        previousValues.add(currentValue);
        return new MeetingPoint(index, currentValue);
    }
}
