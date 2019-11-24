package laddergame.domain;

import laddergame.exception.LadderResultIndexNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderLineResultTest {

    private LadderLineResult ladderLineResult;

    @BeforeEach
    void setUp() {
        ladderLineResult = new LadderLineResult(Arrays.asList(0, 2, 3, 1));
    }

    @Test
    void findIndexOfSource() {
        assertThat(ladderLineResult.findIndexOfSource(1)).isEqualTo(3);
        assertThat(ladderLineResult.findIndexOfSource(2)).isEqualTo(1);

        assertThrows(LadderResultIndexNotFoundException.class, () -> ladderLineResult.findIndexOfSource(4));
    }
}