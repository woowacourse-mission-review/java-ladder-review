package laddergame.domain.ladderplayer;

import laddergame.exception.DuplicatePlayersException;
import laddergame.exception.LackOfPlayersException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void createPlayers_LackOfPlayersException() {
        List<LadderPlayer> players = Collections.singletonList(LadderPlayer.from("red"));
        Exception exception = assertThrows(LackOfPlayersException.class, () -> LadderPlayers.create(players));

        assertThat(exception.getMessage()).isEqualTo(LackOfPlayersException.LACK_OF_PLAYERS_MESSAGE);
    }

    @Test
    void createPlayers_DuplicatePlayersException() {
        List<LadderPlayer> players = Arrays.asList(LadderPlayer.from("red"), LadderPlayer.from("blue"), LadderPlayer.from("red"));
        Exception exception = assertThrows(DuplicatePlayersException.class, () -> LadderPlayers.create(players));

        assertThat(exception.getMessage()).isEqualTo(DuplicatePlayersException.DUPLICATE_PLAYERS_MESSAGE);
    }
}