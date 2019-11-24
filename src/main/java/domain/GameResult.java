package domain;

import java.util.Map;

public class GameResult {
    private final Map<Player, Reward> result;

    public GameResult(final Map<Player, Reward> result) {
        this.result = result;
    }
}
