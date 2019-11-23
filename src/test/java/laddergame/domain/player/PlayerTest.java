package laddergame.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = Player.of("red");
    }

    @Test
    @DisplayName("Player 이름으로 생성하기")
    void create() {
        assertThat(player.getPlayerName()).isEqualTo("red");
    }

    @Test
    void matchName() {
        assertThat(player.matchName("red")).isTrue();
        assertThat(player.matchName("blue")).isFalse();
    }
}