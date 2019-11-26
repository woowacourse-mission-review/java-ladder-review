package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponents;
import games.laddergame.domain.GameResult;
import games.laddergame.domain.ladder.ladderrowmaker.LadderRowMakers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Row> ladder;

    public Ladder(int height, LadderRowMakers ladderRowMakers) {
        this.ladder = IntStream.rangeClosed(0, height - 1)
                .mapToObj(ladderRowMakers::createRowCurrentRow)
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return ladder.size();
    }

    public int getWidth() {
        return ladder.get(0).size() + 1;
    }

    public List<Row> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public GameResult climbDownLadder(GameComponents players, GameComponents prizes) {
        ladder.forEach(row -> row.playCurrentRow(players));
        return new GameResult(players.getComponents(), prizes.getComponents(), Collections.unmodifiableList(ladder));
    }
}
