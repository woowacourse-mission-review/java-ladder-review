package laddergame.domain;

import laddergame.exception.IllegalHeightException;
import laddergame.exception.LackOfHeightException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {

    @Test
    void create() {
        LadderHeight ladderHeightByString = LadderHeight.from("10");
        LadderHeight ladderHeightByLong = LadderHeight.from(10);

        assertThat(ladderHeightByString.getHeight()).isEqualTo(10L);
        assertThat(ladderHeightByLong.getHeight()).isEqualTo(10L);
    }

    @Test
    void create_IllegalHeightException() {
        Exception exception = assertThrows(IllegalHeightException.class, () -> LadderHeight.from(null));

        assertThat(exception.getMessage()).isEqualTo(IllegalHeightException.ILLEGAL_HEIGHT_MESSAGE);
    }

    @Test
    void create_LackOfHeightException() {
        Exception exception = assertThrows(LackOfHeightException.class, () -> LadderHeight.from(0));

        assertThat(exception.getMessage()).isEqualTo(LackOfHeightException.LACK_OF_HEIGHT_MESSAGE);
    }

    @Test
    void equals() {
        LadderHeight ladderHeight = LadderHeight.from("10");

        assertThat(ladderHeight).isEqualTo(LadderHeight.from(10));
    }
}