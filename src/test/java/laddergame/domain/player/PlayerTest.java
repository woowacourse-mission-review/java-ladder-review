package laddergame.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    @DisplayName("Player 이름으로 생성하기")
    void create() {
        Player player = new Player("red");

        assertThat(player.getName()).isEqualTo("red");
    }
}