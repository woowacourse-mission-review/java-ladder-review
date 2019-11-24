package domain;

import domain.strategy.EmptyLineCreateStrategy;
import domain.strategy.HasLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderTest {
    private static final Height HEIGHT_SIZE = new Height("5");
    private static final int LINE_SIZE = 3;

    @Test
    @DisplayName("사다리 높이와 라인 개수를 가지고 사다리 객체를 생성한다.")
    void create_Ladder() {
        assertDoesNotThrow(() -> new Ladder(HEIGHT_SIZE, LINE_SIZE, new HasLineCreateStrategy()));
    }

    @Test
    @DisplayName("domain.strategy.HasLineCreateStrategy 을 가지고 사다리를 만든 후 게임을 진행한다. 시작 위치를 매개변수로 입력하면, 결과 위치를 반환한다.")
    void run_Ladder_with_HasLineCreateStrategy() {
        Ladder ladder = new Ladder(HEIGHT_SIZE, LINE_SIZE, new HasLineCreateStrategy());

        assertThat(ladder.run(0)).isEqualTo(1);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(3);
        assertThat(ladder.run(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("domain.strategy.EmptyLineCreateStrategy 을 가지고 사다리를 만든 후 게임을 진행한다. 시작 위치를 매개변수로 입력하면, 결과 위치를 반환한다.")
    void run_Ladder_with_EmptyLineCreateStrategy() {
        Ladder ladder = new Ladder(HEIGHT_SIZE, LINE_SIZE, new EmptyLineCreateStrategy());

        assertThat(ladder.run(0)).isEqualTo(0);
        assertThat(ladder.run(1)).isEqualTo(1);
        assertThat(ladder.run(2)).isEqualTo(2);
        assertThat(ladder.run(3)).isEqualTo(3);
    }
}
