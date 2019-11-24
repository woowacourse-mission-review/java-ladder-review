import java.util.ArrayList;
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

    private boolean hasLeftLine(int index) {
        if (index == START_INDEX) {
            return false;
        }

        int preIndex = index - 1;
        return getLine(preIndex).isDrawn();
    }

    public int move(int currentIndex) {
        if (rightMove(currentIndex)) {
            return currentIndex + 1;
        }

        if (leftMove(currentIndex)) {
            return currentIndex - 1;
        }

        return currentIndex;
    }

    private boolean rightMove(int index) {
        if (index == size) {
            return false;
        }

        return getLine(index).isDrawn();
    }

    private boolean leftMove(int index) {
        if (index == START_INDEX) {
            return false;
        }

        int preIndex = index - 1;
        return getLine(preIndex).isDrawn();
    }

    public boolean hasLineAt(int index) {
        return getLine(index).isDrawn();
    }

    private Line getLine(int index) {
        return lines.get(index);
    }
}
