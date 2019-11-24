package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {
    private Name name;

    @Test
    @DisplayName("Name 생성")
    void create_name() {
        String name = "pobi";
        assertDoesNotThrow(() -> this.name = new Name(name));
        assertEquals(this.name.getName(), name);
    }

    @Test
    @DisplayName("공백 이름 생성 에러")
    void create_empty_name_error() {
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> this.name = new Name(name));
    }
}
