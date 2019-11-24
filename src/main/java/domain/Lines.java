package domain;

import domain.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private static final int START_INDEX = 0;

    private final int size;
    private List<Line> lines = new ArrayList<>();

    public Lines(int size, LineCreateStrategy strategy) {
        this.size = size;
        initialize(strategy);
    }

    private void initialize(LineCreateStrategy strategy) {
        for (int index = START_INDEX; index < size; ++index) {
            Line currentLine = new Line();
            boolean hasLeftLine = hasLeftLine(index);
            currentLine.initialize(hasLeftLine, strategy);
            lines.add(currentLine);
        }
    }

    public int move(int currentIndex) {
        if (hasLeftLine(currentIndex)) {
            return currentIndex - 1;
        }

        if (hasRightLine(currentIndex)) {
            return currentIndex + 1;
        }

        return currentIndex;
    }

    private boolean hasLeftLine(int index) {
        if (isLocatedStartPosition(index)) {
            return false;
        }

        int preIndex = index - 1;
        return getLine(preIndex).isDrawn();
    }

    private boolean hasRightLine(int index) {
        if (isLocatedFinalPosition(index)) {
            return false;
        }

        return getLine(index).isDrawn();
    }

    private boolean isLocatedStartPosition(int index) {
        return index == START_INDEX;
    }

    private boolean isLocatedFinalPosition(int index) {
        return index == size;
    }

    public boolean hasLineAt(int index) {
        return getLine(index).isDrawn();
    }

    private Line getLine(int index) {
        return lines.get(index);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
