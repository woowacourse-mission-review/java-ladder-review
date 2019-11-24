package laddergame.domain;

import laddergame.exception.LadderResultIndexNotFoundException;

import java.util.List;

public class LadderGameResult {

    private final List<LadderLineResult> ladderLineResults;

    public LadderGameResult(final List<LadderLineResult> ladderLineResults) {
        this.ladderLineResults = ladderLineResults;
    }

    public LadderLineResult findLineResult(int index) {
        return ladderLineResults.get(index);
    }

    public Integer findIndexOfSourceAtLine(final int lineNumber, final int sourceIndex) {
        try {
            int realIndexOfLineResult = lineNumber - 1;
            LadderLineResult ladderLineResult = ladderLineResults.get(realIndexOfLineResult);

            return ladderLineResult.findIndexOfSource(sourceIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new LadderResultIndexNotFoundException(e);
        }
    }
}
