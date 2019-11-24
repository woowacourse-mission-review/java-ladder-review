package ghostleg.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    private Line testLine;

    @BeforeEach
    void setUp() {
        testLine = new Line(
                new NumOfPlayers(3),
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

    @Test
    void invalidFirstPoint() {
        assertThrows(IllegalArgumentException.class, () -> new Line(
                new NumOfPlayers(2),
                new Point(true, false),
                new Point(false, false)
        ));
    }

    @Test
    void invalidLastPoint() {
        assertThrows(IllegalArgumentException.class, () -> new Line(
                new NumOfPlayers(2),
                new Point(false, false),
                new Point(false, true)
        ));
    }

    @Test
    void inconsistentPoints() {
        assertThrows(IllegalArgumentException.class, () -> new Line(
                new NumOfPlayers(2),
                new Point(false, true),
                new Point(false, false)
        ));
    }

    @Test
    void invalidNumOfPoints() {
        assertThrows(IllegalArgumentException.class, () -> new Line(
                new NumOfPlayers(3),
                new Point(false, true),
                new Point(true, false)
        ));
    }
}