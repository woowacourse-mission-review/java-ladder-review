package laddergame.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    private Players players;

    @BeforeEach
    void setUp() {
        List<Player> playerList = Arrays.asList(Player.of("red"), Player.of("blue"), Player.of("green"));
        players = Players.create(playerList);
    }

    @Test
    void size() {
        assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void hasPlayerWithName() {
        assertThat(players.hasPlayerWithName("red")).isTrue();
        assertThat(players.hasPlayerWithName("blue")).isTrue();
        assertThat(players.hasPlayerWithName("green")).isTrue();

        assertThat(players.hasPlayerWithName("black")).isFalse();
    }
}