package domain;

import domain.exception.InvalidHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeightTest {
    @Test
    @DisplayName("Height 생성")
    void create_height() {
        assertDoesNotThrow(() -> new Height("1"));
    }

    @Test
    @DisplayName("1 미만의 높이를 입력할경우 에러")
    void create_under_1_height_error() {
        assertThrows(InvalidHeightException.class, () -> new Height("0"));
    }

    @Test
    @DisplayName("정수가 아닌 높이를 입력할 경우 에러")
    void create_not_integer_error() {
        assertThrows(InvalidHeightException.class, () -> new Height("abc"));
    }
}
