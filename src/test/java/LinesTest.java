import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinesTest {
    private static final int LINE_SIZE = 3;

    @Test
    @DisplayName("HasLineCreateStrategy 전략을 이용하여 사다리 한 줄을 만든다.")
    void create_Lines_with_HasLineCreateStrategy() {
        Lines lines = new Lines(LINE_SIZE, new HasLineCreateStrategy());

        assertTrue(lines.hasLineAt(0));
        assertFalse(lines.hasLineAt(1));
        assertTrue(lines.hasLineAt(2));
    }

    @Test
    @DisplayName("EmptyLineCreateStrategy 전략을 이용하여 사다리 한 줄을 만든다.")
    void create_Lines_with_EmptyLineCreateStrategy() {
        Lines lines = new Lines(LINE_SIZE, new EmptyLineCreateStrategy());

        assertFalse(lines.hasLineAt(0));
        assertFalse(lines.hasLineAt(1));
        assertFalse(lines.hasLineAt(2));
    }

    @Test
    @DisplayName("HasLineCreateStrategy 전략을 이용하여 사다리 생성 후 해당 사다리에서 움직인다.")
    void move_Lines_with_HasLineCreateStrategy() {
        Lines lines = new Lines(LINE_SIZE, new HasLineCreateStrategy());

        assertThat(lines.move(0)).isEqualTo(1);
        assertThat(lines.move(1)).isEqualTo(0);
        assertThat(lines.move(2)).isEqualTo(3);
        assertThat(lines.move(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("EmptyLineCreateStrategy 전략을 이용하여 사다리 생성 후 해당 사다리에서 움직인다.")
    void move_Lines_with_EmptyLineCreateStrategy() {
        Lines lines = new Lines(LINE_SIZE, new EmptyLineCreateStrategy());

        assertThat(lines.move(0)).isEqualTo(0);
        assertThat(lines.move(1)).isEqualTo(1);
        assertThat(lines.move(2)).isEqualTo(2);
        assertThat(lines.move(3)).isEqualTo(3);
    }
}
