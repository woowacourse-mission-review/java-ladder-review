package laddergame.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPlayersTest {

    private LadderPlayers ladderPlayers;

    @BeforeEach
    void setUp() {
        List<LadderPlayer> players = Arrays.asList(LadderPlayer.from("red"), LadderPlayer.from("blue"), LadderPlayer.from("green"));
        ladderPlayers = LadderPlayers.create(players);
    }

    @Test
    void size() {
        assertThat(ladderPlayers.size()).isEqualTo(3);
    }

    @Test
    void hasPlayerWithName() {
        assertThat(ladderPlayers.hasPlayerWithName("red")).isTrue();
        assertThat(ladderPlayers.hasPlayerWithName("blue")).isTrue();
        assertThat(ladderPlayers.hasPlayerWithName("green")).isTrue();

        assertThat(ladderPlayers.hasPlayerWithName("black")).isFalse();
    }
}