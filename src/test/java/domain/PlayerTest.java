package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;

    @Test
    @DisplayName("참가자 등록")
    void register_player() {
        String name = "pobi";
        assertDoesNotThrow(() -> player = new Player(name));
    }

    @Test
    @DisplayName("공백을 이름으로 입력했을 때 에러")
    void register_empty_name() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> player = new Player(name));
    }

    @Test
    @DisplayName("같은 이름 Player Equals True")
    void equals() {
        Player player1 = new Player("A");
        Player player2 = new Player("A");

        assertEquals(player1, player2);
    }

    @Test
    @DisplayName("다른 이름 Player Equals False")
    void not_equals() {
        Player player1 = new Player("A");
        Player player2 = new Player("B");

        assertNotEquals(player1, player2);
    }
}
