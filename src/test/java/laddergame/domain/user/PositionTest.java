package laddergame.domain.user;

import laddergame.domain.user.exception.InvalidPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @Test
    void valid_position() {
        assertDoesNotThrow(() -> new Position(0));
    }

    @Test
    void invalid_position() {
        assertThrows(InvalidPositionException.class, () -> new Position(-1));
    }
}