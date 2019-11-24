package laddergame.domain.ladder;

import laddergame.domain.ladder.exception.InvalidHeightException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {

    @Test
    void valid_height() {
        int height = 10;
        assertDoesNotThrow(() -> Height.of(height));
    }

    @Test
    void invalid_height() {
        int height = -10;
        assertThrows(InvalidHeightException.class, () -> Height.of(height));
    }
}