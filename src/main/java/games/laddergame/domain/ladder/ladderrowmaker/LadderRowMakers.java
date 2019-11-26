package games.laddergame.domain.ladder.ladderrowmaker;

import games.laddergame.domain.ladder.Row;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderRowMakers {
    private List<LadderRowMaker> rowMakers;

    public LadderRowMakers(List<LadderRowMaker> rowMakers) {
        this.rowMakers = rowMakers;
    }

    public LadderRowMakers(int width, int height) {
        this.rowMakers = IntStream.rangeClosed(0, height)
                .mapToObj(index -> new DefaultLadderRowMaker(width))
                .collect(Collectors.toList());
    }

    public Row createRowCurrentRow(int index) {
        return rowMakers.get(index).createRow();
    }
}
