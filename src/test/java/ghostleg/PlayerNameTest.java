package ghostleg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerNameTest {
    @Test
    void validateNoKorean() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName("무민"));
    }

    @Test
    void validateNoSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName("Moomin!!@#$@"));
    }

    @Test
    void correctName() {
        new PlayerName("Moomin the Moomin");
    }

    @Test
    void atMost20Characters() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName("The secret of business is to know something that nobody else knows"));
    }

    @Test
    void atLeast3Characters() {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName("hi"));
    }
}