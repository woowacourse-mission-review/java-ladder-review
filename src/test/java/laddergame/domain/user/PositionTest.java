package laddergame.domain.user;

import laddergame.domain.user.exception.InvalidPositionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @Test
    void valid_position() {
        assertDoesNotThrow(() -> Position.of(0));
    }

    @Test
    void invalid_position() {
        assertThrows(InvalidPositionException.class, () -> Position.of(-1));
    }
}