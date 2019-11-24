package domain;

import domain.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int START_INDEX = 0;

    private final Height height;
    private final int lineSize;
    private List<Lines> ladder = new ArrayList<>();

    public Ladder(Height height, int lineSize, LineCreateStrategy strategy) {
        this.height = height;
        this.lineSize = lineSize;
        initialize(strategy);
    }

    private void initialize(LineCreateStrategy strategy) {
        for (int index = START_INDEX; index < height.getHeight(); index++) {
            ladder.add(new Lines(lineSize, strategy));
        }
    }

    public int run(int startLineIndex) {
        int resultLineIndex = startLineIndex;
        for (int index = START_INDEX; index < height.getHeight(); index++) {
            resultLineIndex = ladder.get(index).move(resultLineIndex);
        }

        return resultLineIndex;
    }

    public List<Lines> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
