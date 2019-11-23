package laddergame.service;

import laddergame.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameServiceTest {

    private LadderGameService ladderGameService;

    @BeforeEach
    void setUp() {
        ladderGameService = new LadderGameService();
    }

    @Test
    void createPlayers() {
        Players players = ladderGameService.createPlayers("red, blue, green");

        assertThat(players).isNotNull();
        assertThat(players.size()).isEqualTo(3);
        assertThat(players.hasPlayerWithName("red")).isTrue();
        assertThat(players.hasPlayerWithName("blue")).isTrue();
        assertThat(players.hasPlayerWithName("green")).isTrue();
    }
}