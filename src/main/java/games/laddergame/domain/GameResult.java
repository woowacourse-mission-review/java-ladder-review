package games.laddergame.domain;

import games.laddergame.domain.ladder.Row;

import java.util.Collections;
import java.util.List;

public class GameResult {
    private List<GameComponent> players;
    private List<GameComponent> prizes;
    private List<Row> ladder;

    public GameResult(List<GameComponent> players, List<GameComponent> prizes, List<Row> ladder) {
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public List<GameComponent> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public List<Row> getLadder() {
        return ladder;
    }

    public List<GameComponent> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
