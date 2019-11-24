package laddergame.domain.ladder;

import laddergame.domain.LadderLineResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = Ladder.of(() -> true, 4, 3);
    }

    @Test
    void of() {
        assertThat(ladder).isNotNull();
    }

    @Test
    void getStringsOfLadderLines() {
        Ladder ladder = Ladder.of(() -> true, 4, 3);
        List<String> stringsOfLadderLines = ladder.getStringsOfLadderLines(5);

        for (String stringOfLadderLine : stringsOfLadderLines) {
            assertThat(stringOfLadderLine).isEqualTo("|-----|     |-----|");
        }
    }

    @Test
    void createLineResults() {
        List<LadderLineResult> lineResults = ladder.createLineResults();

        assertThat(lineResults.size()).isEqualTo(3);

        assertThat(lineResults.get(0).findIndexOfSource(0)).isEqualTo(1);
        assertThat(lineResults.get(1).findIndexOfSource(0)).isEqualTo(0);
        assertThat(lineResults.get(2).findIndexOfSource(0)).isEqualTo(1);
    }
}