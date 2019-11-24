package ghostleg;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final ArrayList<Line> lines;
    private int currentHeight;

    public Ladder(LadderHeight ladderHeight, Line... lines) {
        validateLadderHeight(ladderHeight, lines);
        this.lines = Lists.newArrayList(lines);
    }

    private void validateLadderHeight(LadderHeight ladderHeight, Line[] lines) {
        if (ladderHeight.getValue() != lines.length) {
            throw new IllegalArgumentException("사다리의 높이와 라인의 수가 일치해야 합니다.");
        }
    }

    public List<Direction> proceed() {
        Line currentLine = lines.get(currentHeight++);
        return currentLine.getNextAll();
    }
}
