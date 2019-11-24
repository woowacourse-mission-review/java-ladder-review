package domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class GameResult {
    private final Map<Player, Reward> result;

    public GameResult(final Map<Player, Reward> result) {
        this.result = result;
    }

    public Reward getResult(final Player player) {
        if (!result.containsKey(player)) {
            throw new IllegalArgumentException("해당 이름의 참가자가 존재하지 않습니다.");
        }
        return result.get(player);
    }

    public void forEach(final BiConsumer<Player, Reward> consumer) {
        result.forEach(consumer);
    }
}
