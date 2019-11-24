package laddergame.domain;

import laddergame.exception.LadderResultIndexNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameResultTest {

    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        LadderLineResult ladderLineResult1 = new LadderLineResult(Arrays.asList(0, 2, 1, 3));
        LadderLineResult ladderLineResult2 = new LadderLineResult(Arrays.asList(2, 0, 3, 1));
        LadderLineResult ladderLineResult3 = new LadderLineResult(Arrays.asList(2, 3, 0, 1));

        ladderGameResult = new LadderGameResult(Arrays.asList(ladderLineResult1, ladderLineResult2, ladderLineResult3));
    }

    @Test
    void findLineResult() {
        LadderLineResult lineResult = ladderGameResult.findLineResult(1);

        assertThat(lineResult.findIndexOfSource(0)).isEqualTo(2);
        assertThat(lineResult.findIndexOfSource(1)).isEqualTo(0);
        assertThat(lineResult.findIndexOfSource(2)).isEqualTo(3);
        assertThat(lineResult.findIndexOfSource(3)).isEqualTo(1);
    }

    @Test
    void findIndexOfSourceAtLine() {
        assertThat(ladderGameResult.findIndexOfSourceAtLine(3, 3)).isEqualTo(1);
        assertThat(ladderGameResult.findIndexOfSourceAtLine(1, 3)).isEqualTo(3);

        assertThrows(LadderResultIndexNotFoundException.class
                , () -> ladderGameResult.findIndexOfSourceAtLine(0, 3));
    }
}