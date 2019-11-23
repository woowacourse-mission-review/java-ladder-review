import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    void goLeftTest() {
        Point testPoint = new Point(true, false);
        assertThat(testPoint.next()).isEqualTo(-1);
    }

    @Test
    void goRightTest() {
        Point testPoint = new Point(false, true);
        assertThat(testPoint.next()).isEqualTo(1);
    }

    @Test
    void goStraightTest() {
        Point testPoint = new Point(false, false);
        assertThat(testPoint.next()).isEqualTo(0);
    }
}