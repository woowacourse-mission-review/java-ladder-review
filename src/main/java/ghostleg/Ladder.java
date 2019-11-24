package ghostleg;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final ArrayList<Line> lines;
    private int currentHeight;

    public Ladder(Line... lines) {
        this.lines = Lists.newArrayList(lines);
    }

    public List<Direction> proceed() {
        Line currentLine = lines.get(currentHeight++);
        return currentLine.getNextAll();
    }
}
