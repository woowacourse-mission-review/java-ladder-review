package domain;

import domain.exception.InvalidHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeightTest {

    @Test
    @DisplayName("문자열을 입력받아 정상적으로 사다리 높이를 생성한다.")
    void create_Height() {
        assertDoesNotThrow(() -> new Height("5"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자열로 사다리 높이를 생성할 때 예외가 발생한다.")
    void create_Height_with_not_number() {
        String notNumber = "a";
        assertThrows(InvalidHeightException.class, () -> new Height(notNumber));
    }

    @Test
    @DisplayName("음수인 문자열로 사다리 높이를 생성할 때 예외가 발생한다.")
    void create_Height_with_negative_number() {
        String negativeNumber = "-1";
        assertThrows(InvalidHeightException.class, () -> new Height(negativeNumber));
    }

    @Test
    @DisplayName("실수인 문자열로 사다리 높이를 생성할 때 예외가 발생한다.")
    void create_Height_with_not_integer() {
        String notIntegerNumber = "1.23";
        assertThrows(InvalidHeightException.class, () -> new Height(notIntegerNumber));
    }
}
