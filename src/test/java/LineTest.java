import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("현재 사다리 인덱스를 가지고 사다리 라인을 생성한다.")
    void create_Line() {
        assertDoesNotThrow(() -> new Line(0));
    }

    @Test
    @DisplayName("라인을 가지고 있는 Line 객체를 생성한다.")
    void create_Line_with_line() {
        Line line = new Line(0);
        LineCreateStrategy strategy = new HasLineCreateStrategy();
        line.initialize(false, false, strategy);

        assertTrue(line.getLine());
    }

    @Test
    @DisplayName("라인을 가지고 있지 않는 Line 객체를 생성한다.")
    void create_Line_without_line() {
        Line line = new Line(0);
        LineCreateStrategy strategy = new EmptyLineCreateStrategy();
        line.initialize(false, false, strategy);

        assertFalse(line.getLine());
    }
}
