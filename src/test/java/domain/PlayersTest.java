package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    private Players players;

    @Test
    @DisplayName("참가자 등록")
    void register_players() {
        String playersInput = "pobi, honux, crong, jk";
        assertDoesNotThrow(() -> players = new Players(playersInput));
    }

    @Test
    @DisplayName("참가자를 등록하지 않았을 때 에러")
    void register_0_players_error() {
        String playersInput = "";
        assertThrows(IllegalArgumentException.class, () -> players = new Players(playersInput));
    }

    @Test
    @DisplayName("참가자 1명을 등록했을 때 에러")
    void register_1_player_error() {
        String playersInput = "pobi";
        assertThrows(IllegalArgumentException.class, () -> players = new Players(playersInput));
    }

    @Test
    @DisplayName("참가자로 같은 이름을 입력했을 경우 에러")
    void register_same_name_player_error() {
        String playersInput = "pobi, pobi";
        assertThrows(IllegalArgumentException.class, () -> players = new Players(playersInput));
    }
}
