package ghostleg.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RewardTest {
    @Test
    void atLeastOneCharacter() {
        assertThrows(IllegalArgumentException.class, () -> new Reward(""));
    }

    @Test
    void atMost10Characters() {
        assertThrows(IllegalArgumentException.class, () -> new Reward("123456789021"));
    }
}