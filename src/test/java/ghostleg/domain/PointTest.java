package ghostleg.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {
    @Test
    void goLeftTest() {
        Point testPoint = new Point(true, false);
        assertThat(testPoint.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void goRightTest() {
        Point testPoint = new Point(false, true);
        assertThat(testPoint.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void goStraightTest() {
        Point testPoint = new Point(false, false);
        assertThat(testPoint.move()).isEqualTo(Direction.STRAIGHT);
    }

    @DisplayName("한 점의 양쪽에 모두 다리가 놓일 수 없다")
    @Test
    void noConsecutiveBridge() {
        assertThrows(IllegalArgumentException.class, () -> new Point(true, true));
    }
}