package laddergame.domain.ladder;

import laddergame.exception.IllegalDirectionFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {

    private Direction left;
    private Direction right;
    private Direction none;

    @BeforeEach
    void setUp() {
        left = Direction.LEFT;
        right = Direction.RIGHT;
        none = Direction.NONE;
    }

    @Test
    void getFirst() {
        assertThat(Direction.getFirst(true)).isEqualByComparingTo(right);
        assertThat(Direction.getFirst(false)).isEqualByComparingTo(none);
    }

    @Test
    void getLast() {
        assertThat(Direction.getLast(true)).isEqualByComparingTo(left);
        assertThat(Direction.getLast(false)).isEqualByComparingTo(none);
    }

    @Test
    void valueOf() {
        assertThrows(IllegalDirectionFoundException.class, () -> Direction.valueOf(true, true));

        assertThat(Direction.valueOf(true, false)).isEqualByComparingTo(left);
        assertThat(Direction.valueOf(false, true)).isEqualByComparingTo(right);
        assertThat(Direction.valueOf(false, false)).isEqualByComparingTo(none);
    }

    @Test
    void decideNext() {
        Direction nextOfLeft = left.decideNext(() -> true);
        assertThat(nextOfLeft.hasLeft()).isFalse();
        assertThat(nextOfLeft.hasRight()).isTrue();

        Direction nextOfRight = right.decideNext(() -> true);
        assertThat(nextOfRight.hasLeft()).isTrue();
        assertThat(nextOfRight.hasRight()).isFalse();
    }

    @Test
    void hasLeft() {
        assertThat(left.hasLeft()).isTrue();
        assertThat(right.hasLeft()).isFalse();
    }

    @Test
    void hasRight() {
        assertThat(left.hasRight()).isFalse();
        assertThat(right.hasRight()).isTrue();
    }
}