package laddergame.domain.ladder;

import laddergame.domain.LadderLineResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public List<LadderLineResult> createLineResults() {
        List<Integer> currentIndices = generateFirstIndices();

        List<LadderLineResult> lineResults = new ArrayList<>();
        for (LadderLine line : lines) {
            currentIndices = line.moveToNextIndex(currentIndices);
            lineResults.add(new LadderLineResult(currentIndices));
        }
        return lineResults;
    }

    private List<Integer> generateFirstIndices() {
        int width = getWidth();
        return IntStream.range(0, width)
                .boxed()
                .collect(Collectors.toList());
    }

    private int getWidth() {
        LadderLine ladderLine = lines.get(0);
        return ladderLine.size();
    }
}
