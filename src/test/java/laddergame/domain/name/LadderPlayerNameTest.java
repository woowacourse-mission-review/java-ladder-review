package laddergame.domain.name;

import laddergame.exception.ExcessOfPlayerNameException;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderPlayerNameTest {

    private LadderPlayerName ladderPlayerName;

    @BeforeEach
    void setUp() {
        ladderPlayerName = new LadderPlayerName("red");
    }

    @Test
    @DisplayName("PlayerName 이름으로 생성하기")
    void create() {
        assertThat(ladderPlayerName.getName()).isEqualTo("red");
    }

    @Test
    void equals() {
        assertThat(ladderPlayerName).isEqualTo(new LadderPlayerName("red"));
    }

    @Test
    @DisplayName("지정한 이름 길이 초과하는 경우")
    void create_ExcessOfPlayerNameException() {
        assertDoesNotThrow(() -> new LadderPlayerName("green"));

        Exception exception = assertThrows(ExcessOfPlayerNameException.class, () -> new LadderPlayerName("violet"));
        assertThat(exception.getMessage()).isEqualTo(ExcessOfPlayerNameException.EXCESS_OF_PLAYER_NAME_MESSAGE);
    }

    @Test
    void matchName() {
        assertThat(ladderPlayerName.matchName("red")).isTrue();
        assertThat(ladderPlayerName.matchName("blue")).isFalse();
    }

    @Test
    void getAlignedName() {
        String playerName = ladderPlayerName.getName();
        int numOfBlanks = LadderPlayerName.MAX_LEN_OF_PLAYER_NAME - playerName.length();

        String expected = playerName + StringUtils.repeat(" ", numOfBlanks);

        assertThat(ladderPlayerName.getAlignedName()).isEqualTo(expected);
    }
}