package ghostleg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NumOfPlayersTest {
    @Test
    void atLeastTwoPlayers() {
        assertThrows(IllegalArgumentException.class, () -> new NumOfPlayers(1));
    }

    @Test
    void atMost100Players() {
        assertThrows(IllegalArgumentException.class, () -> new NumOfPlayers(101));
    }
}