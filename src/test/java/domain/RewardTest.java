package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RewardTest {
    private Reward reward;

    @Test
    @DisplayName("참가자 등록")
    void register_player() {
        String name = "pobi";
        assertDoesNotThrow(() -> reward = new Reward(name));
    }

    @Test
    @DisplayName("공백을 이름으로 입력했을 때 에러")
    void register_empty_name() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> reward = new Reward(name));
    }


    @Test
    @DisplayName("같은 이름 Equals True")
    void equals() {
        Reward reward1 = new Reward("A");
        Reward reward2 = new Reward("A");

        assertEquals(reward1, reward2);
    }

    @Test
    @DisplayName("다른 이름 Equals False")
    void not_equals() {
        Reward reward1 = new Reward("A");
        Reward reward2 = new Reward("B");

        assertNotEquals(reward1, reward2);
    }
}
