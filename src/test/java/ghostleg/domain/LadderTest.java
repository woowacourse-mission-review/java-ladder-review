package ghostleg.domain;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {
    private Ladder testLadder;

    @BeforeEach
    void setup() {
        NumOfPlayers numOfPlayers = new NumOfPlayers(3);
        testLadder = new Ladder(
                new LadderHeight(2),
                new Line(
                        numOfPlayers,
                        new Point(false, true),
                        new Point(true, false),
                        new Point(false, false)
                ),
                new Line(
                        numOfPlayers,
                        new Point(false, false),
                        new Point(false, true),
                        new Point(true, false)
                )
        );
    }

    @Test
    void illegalHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(
                new LadderHeight(100),
                new Line(
                        new NumOfPlayers(2),
                        new Point(false, true),
                        new Point(true, false)
                )
        ));
    }

    @Test
    void proceedOneStep() {
        assertThat(testLadder.proceed()).isEqualTo(Lists.newArrayList(
                Direction.RIGHT,
                Direction.LEFT,
                Direction.STRAIGHT
        ));
        assertThat(testLadder.proceed()).isEqualTo(Lists.newArrayList(
                Direction.STRAIGHT,
                Direction.RIGHT,
                Direction.LEFT
        ));
    }
}