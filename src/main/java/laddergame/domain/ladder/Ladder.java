package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<LadderLine> lines;

    private Ladder(final List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(final LadderCreationStrategy strategy, final int width, final int height) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            LadderLine ladderLine = LadderLine.of(strategy, width);
            lines.add(ladderLine);
        }

        return new Ladder(lines);
    }

    public List<String> getStringsOfLadderLines(final int widthOfCrossBar) {
        return lines.stream()
                .map(ladderLine -> ladderLine.getStringOfLadderLine(widthOfCrossBar))
                .collect(Collectors.toList());
    }
}
