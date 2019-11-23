package laddergame.domain.user;

import laddergame.domain.user.exception.InvalidNameSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    @DisplayName("올바른 이름으로 생성 test")
    void valid_name() {
        String name = "conas";
        assertDoesNotThrow(() -> new Name(name));
    }

    @Test
    @DisplayName("5글자가 넘어가는 경우 test")
    void invalid_size_name() {
        String name = "conatuseus";
        assertThrows(InvalidNameSizeException.class, () -> new Name(name));
    }

    @Test
    @DisplayName("blank 이름인 경우 test")
    void blank_name() {
        String name = "";
        assertThrows(InvalidNameSizeException.class, () -> new Name(name));
    }
}