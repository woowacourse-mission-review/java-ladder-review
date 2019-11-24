package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void of() {
        Ladder ladder = Ladder.of(() -> true, 3, 3);

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
}