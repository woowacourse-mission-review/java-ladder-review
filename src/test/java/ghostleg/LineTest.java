package ghostleg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private Line testLine;

    @BeforeEach
    void setUp() {
         testLine = new Line(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false));
    }

    @Test
    void nextPositionIsRight() {
        assertThat(testLine.getNext(0)).isEqualTo(Direction.RIGHT);
    }

    @Test
    void nextPositionIsLeft() {
        assertThat(testLine.getNext(1)).isEqualTo(Direction.LEFT);
    }

    @Test
    void nextPositionIsStraight() {
        assertThat(testLine.getNext(2)).isEqualTo(Direction.STRAIGHT);
    }
}