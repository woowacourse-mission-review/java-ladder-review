package laddergame.domain.ladder;

import laddergame.domain.ladder.exception.InvalidDirectionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DirectionTest {

    @Test
    void valid_direction() {
        boolean left = false;
        boolean right = true;
        assertDoesNotThrow(() -> Direction.of(left, right));
    }

    @Test
    void invalid_direction() {
        boolean left = true;
        boolean right = true;
        assertThrows(InvalidDirectionException.class, () -> Direction.of(left, right));
    }

    @Test
    void canMoveRight() {
        Direction direction = Direction.of(false, true);
        assertTrue(direction.canMoveRight());
    }

    @Test
    void cant_move_right() {
        Direction direction = Direction.of(false, false);
        assertFalse(direction.canMoveRight());
    }

}