package domain;

import domain.exception.InvalidRewardsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardsTest {
    @Test
    @DisplayName("Reward 등록")
    void register_players() {
        String rewardsInput = "O, X, O, X";
        assertDoesNotThrow(() -> new Rewards(rewardsInput, 4));
    }

    @Test
    @DisplayName("참가자 수와 다른 Reward 수 등록 에")
    void register_wrong_rewards_count() {
        String rewardsInput = "O, X, X, O, X";
        assertThrows(InvalidRewardsException.class, () -> new Rewards(rewardsInput, 4));
    }
}
