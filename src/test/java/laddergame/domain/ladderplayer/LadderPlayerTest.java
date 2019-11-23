package laddergame.domain.ladderplayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPlayerTest {

    private LadderPlayer ladderPlayer;

    @BeforeEach
    void setUp() {
        ladderPlayer = LadderPlayer.from("red");
    }

    @Test
    @DisplayName("Player 이름으로 생성하기")
    void create() {
        assertThat(ladderPlayer.getName()).isEqualTo("red");
    }

    @Test
    void matchName() {
        assertThat(ladderPlayer.matchName("red")).isTrue();
        assertThat(ladderPlayer.matchName("blue")).isFalse();
    }
}