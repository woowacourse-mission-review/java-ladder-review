import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinesTest {
    private static final int TEST_LINE_SIZE = 3;

    @Test
    @DisplayName("여러 Line을 가지고 있는 Lines 객체를 생성한다. 이는 사다리 한 줄을 나타낸다.")
    void create_Lines() {
        assertDoesNotThrow(() -> new Lines(TEST_LINE_SIZE));
    }

    @Test
    @DisplayName("HasLineCreateStrategy 전략을 이용하여 사다리 한 줄을 만든다.")
    void create_Lines_HasLineCreateStrategy() {
        Lines lines = new Lines(TEST_LINE_SIZE);
        lines.create(new HasLineCreateStrategy());

        assertTrue(lines.hasLineAt(0));
        assertFalse(lines.hasLineAt(1));
        assertTrue(lines.hasLineAt(2));
    }

    @Test
    @DisplayName("EmptyLineCreateStrategy 전략을 이용하여 사다리 한 줄을 만든다.")
    void create_Lines_EmptyLineCreateStrategy() {
        Lines lines = new Lines(TEST_LINE_SIZE);
        lines.create(new EmptyLineCreateStrategy());

        assertFalse(lines.hasLineAt(0));
        assertFalse(lines.hasLineAt(1));
        assertFalse(lines.hasLineAt(2));
    }
}
