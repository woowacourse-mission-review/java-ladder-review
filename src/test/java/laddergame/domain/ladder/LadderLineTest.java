package laddergame.domain.ladder;

import laddergame.exception.LadderResultIndexNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderLineTest {

    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        ladderLine = LadderLine.of(() -> true, 4);
    }

    @Test
    void of() {
        assertThat(ladderLine).isNotNull();
    }

    @Test
    void getStringOfLadderLine() {
        LadderLine ladderLine = LadderLine.of(() -> true, 4);
        String stringOfLadderLine = ladderLine.getStringOfLadderLine(5);

        assertThat(stringOfLadderLine).isEqualTo("|-----|     |-----|");
    }

    @Test
    void createLineResult() {
        List<Integer> indices = ladderLine.moveToNextIndex(Arrays.asList(0, 1, 2, 3));

        assertThat(indices.get(0)).isEqualTo(1);
        assertThat(indices.get(1)).isEqualTo(0);
        assertThat(indices.get(2)).isEqualTo(3);
        assertThat(indices.get(3)).isEqualTo(2);
    }

    @Test
    void createLineResult_LadderResultIndexNotFoundException() {
        assertThrows(LadderResultIndexNotFoundException.class, () -> ladderLine.moveToNextIndex(Arrays.asList(0, 1, 2)));
    }

    @Test
    void size() {
        assertThat(ladderLine.size()).isEqualTo(4);
    }
}