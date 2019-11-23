package laddergame.service;

import laddergame.domain.ladderplayer.LadderPlayers;
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
        LadderPlayers ladderPlayers = ladderGameService.createPlayers("red, blue, green");

        assertThat(ladderPlayers).isNotNull();
        assertThat(ladderPlayers.size()).isEqualTo(3);
        assertThat(ladderPlayers.hasPlayerWithName("red")).isTrue();
        assertThat(ladderPlayers.hasPlayerWithName("blue")).isTrue();
        assertThat(ladderPlayers.hasPlayerWithName("green")).isTrue();
    }
}