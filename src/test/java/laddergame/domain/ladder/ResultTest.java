package laddergame.domain.ladder;

import laddergame.domain.ladder.exception.InvalidResultValueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultTest {

    @Test
    void valid_result() {
        String result = "1000";
        assertDoesNotThrow(() -> Result.of(result, 0));
    }

    @Test
    void blank_result() {
        String result = "";
        assertThrows(InvalidResultValueException.class, () -> Result.of("", 0));
    }
}