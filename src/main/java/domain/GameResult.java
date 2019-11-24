package domain;

import domain.exception.PlayerNotFoundException;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiConsumer;

public class GameResult {
    private final Map<Player, Reward> result;

    public GameResult(final Map<Player, Reward> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public Reward getResult(final Player player) {
        if (!result.containsKey(player)) {
            throw new PlayerNotFoundException();
        }
        return result.get(player);
    }

    public void forEach(final BiConsumer<Player, Reward> consumer) {
        result.forEach(consumer);
    }
}
