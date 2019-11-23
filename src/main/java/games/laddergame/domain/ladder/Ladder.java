package games.laddergame.domain.ladder;

import games.laddergame.domain.ladder.ladderrowmaker.LadderRowMaker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Row> ladder;

    public Ladder(int width, int height, LadderRowMaker ladderRowMaker) {
        this.ladder = IntStream.rangeClosed(0, height - 1)
                .mapToObj(integer -> ladderRowMaker.createRow())
                .collect(Collectors.toList());
    }

    public int size() {
        return ladder.size();
    }

    public List<Row> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
