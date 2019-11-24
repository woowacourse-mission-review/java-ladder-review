package ghostleg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void positionCannotExceedNumOfPlayers() {
        assertThrows(IllegalArgumentException.class, () -> new Position(10, new NumOfPlayers(10)));
    }

    @Test
    void atLeastZero() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1, new NumOfPlayers(10)));
    }
}