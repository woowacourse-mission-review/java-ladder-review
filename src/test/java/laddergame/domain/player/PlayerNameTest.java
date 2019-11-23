package laddergame.domain.player;

import laddergame.exception.ExcessOfPlayerNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerNameTest {

    @Test
    @DisplayName("PlayerName 이름으로 생성하기")
    void create() {
        PlayerName playerName = new PlayerName("red");

        assertThat(playerName.getName()).isEqualTo("red");
    }

    @Test
    @DisplayName("지정한 이름 길이 초과하는 경우")
    void create_ExcessOfPlayerNameException() {
        assertDoesNotThrow(() -> new PlayerName("green"));

        Exception exception = assertThrows(ExcessOfPlayerNameException.class, () -> new PlayerName("violet"));
        assertThat(exception.getMessage()).isEqualTo(ExcessOfPlayerNameException.EXCESS_OF_PLAYER_NAME_MESSAGE);
    }
}