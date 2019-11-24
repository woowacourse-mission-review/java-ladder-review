import java.util.ArrayList;
import java.util.List;

public class Lines {
    private static final int START_INDEX = 0;

    private final int size;
    private List<Line> lines = new ArrayList<>();

    public Lines(int size) {
        this.size = size;
    }

    public void create(LineCreateStrategy strategy) {
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
        return lines.get(preIndex).getLine();
    }

    public boolean hasLineAt(int index) {
        return lines.get(index).getLine();
    }
}
