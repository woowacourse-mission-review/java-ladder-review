package laddergame.domain;

import laddergame.exception.LadderResultIndexNotFoundException;

import java.util.List;

public class LadderLineResult {

    private final List<Integer> indices;

    public LadderLineResult(final List<Integer> indices) {
        this.indices = indices;
    }

    public Integer findIndexOfSource(int sourceIndex) {
        return indices.stream()
                .filter(integer -> integer.equals(sourceIndex))
                .map(indices::indexOf)
                .findFirst()
                .orElseThrow(LadderResultIndexNotFoundException::new);
    }
}
