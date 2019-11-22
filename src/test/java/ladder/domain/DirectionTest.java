package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("RIGHT.next() LEFT 생성 확인")
    void nextTest01() {
        Direction actual = Direction.RIGHT.next(true);

        assertThat(actual).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("next(true) RIGHT 생성 되는지 확인")
    void nextTest02() {
        Direction actual = Direction.LEFT.next(true);

        assertThat(actual).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("next(false) STRAIGHT 생성 되는지 확인")
    void nextTest03() {
        Direction actual = Direction.LEFT.next(false);

        assertThat(actual).isEqualTo(Direction.STRAIGHT);
    }
}