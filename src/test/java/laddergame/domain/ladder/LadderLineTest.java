package laddergame.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @Test
    void of() {
        LadderLine ladderLine = LadderLine.of(() -> true, 3);

        assertThat(ladderLine).isNotNull();
    }

    @Test
    void getStringOfLadderLine() {
        LadderLine ladderLine = LadderLine.of(() -> true, 3);
        String stringOfLadderLine = ladderLine.getStringOfLadderLine(5);

        assertThat(stringOfLadderLine).isEqualTo("|-----|     |-----|");
    }
}