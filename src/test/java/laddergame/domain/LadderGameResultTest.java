package laddergame.domain;

import laddergame.exception.LadderResultIndexNotFoundException;
import laddergame.exception.PlayerResultNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameResultTest {

    private LadderGameResult ladderGameResult;

    @BeforeEach
    void setUp() {
        LadderLineResult ladderLineResult1 = new LadderLineResult(Arrays.asList(0, 2, 1, 3));
        LadderLineResult ladderLineResult2 = new LadderLineResult(Arrays.asList(2, 0, 3, 1));
        LadderLineResult ladderLineResult3 = new LadderLineResult(Arrays.asList(2, 3, 0, 1));

        ladderGameResult = new LadderGameResult(Arrays.asList("red", "blue", "green", "black")
                , Arrays.asList(ladderLineResult1, ladderLineResult2, ladderLineResult3)
                , Arrays.asList("one", "two", "three", "four"));
    }

    @Test
    void findPlayerResultAtLineNumber() {
        String resultOfLine1 = ladderGameResult.findPlayerResultAtLineNumber(1, "black");
        assertThat(resultOfLine1).isEqualTo("four");

        String resultOfLine2 = ladderGameResult.findPlayerResultAtLineNumber(2, "black");
        assertThat(resultOfLine2).isEqualTo("three");

        String resultOfLine3 = ladderGameResult.findPlayerResultAtLineNumber(3, "black");
        assertThat(resultOfLine3).isEqualTo("two");
    }

    @Test
    void findPlayerResultAtLineNumber_PlayerResultNotFoundException() {
        assertThrows(PlayerResultNotFoundException.class, () -> ladderGameResult.findPlayerResultAtLineNumber(1, "pink"));
    }

    @Test
    void findPlayerResultAtLineNumber_LadderResultIndexNotFoundException() {
        assertThrows(LadderResultIndexNotFoundException.class
                , () -> ladderGameResult.findPlayerResultAtLineNumber(0, "black"));
    }

    @Test
    void findFinalPlayerResult() {
        assertThat(ladderGameResult.findFinalPlayerResult("red")).isEqualTo("three");
        assertThat(ladderGameResult.findFinalPlayerResult("blue")).isEqualTo("four");
        assertThat(ladderGameResult.findFinalPlayerResult("green")).isEqualTo("one");
        assertThat(ladderGameResult.findFinalPlayerResult("black")).isEqualTo("two");
    }

    @Test
    void createAllFinalResults() {
        Map<String, String> allFinalResults = ladderGameResult.createAllFinalResults();

        assertThat(allFinalResults.get("red")).isEqualTo("three");
        assertThat(allFinalResults.get("blue")).isEqualTo("four");
        assertThat(allFinalResults.get("green")).isEqualTo("one");
        assertThat(allFinalResults.get("black")).isEqualTo("two");
    }
}