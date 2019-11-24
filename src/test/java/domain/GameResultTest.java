package domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameResultTest {
    private GameResult gameResult;

    {
        Map<Player, Reward> results = new HashMap<>();
        results.put(new Player("A"), new Reward("1"));
        results.put(new Player("B"), new Reward("2"));
        gameResult = new GameResult(results);
    }

    @Test
    void key_contains() {
        assertThat(gameResult.getResult(new Player("A"))).isEqualTo(new Reward("1"));
    }

    @Test
    void key_not_contains() {
        assertThrows(IllegalArgumentException.class, () -> gameResult.getResult(new Player("C")));
    }
}
