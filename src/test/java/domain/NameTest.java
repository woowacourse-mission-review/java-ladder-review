package domain;

import domain.exception.InvalidNameException;
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
        assertThrows(InvalidNameException.class, () -> new Name(""));
    }

    @Test
    @DisplayName("같은 이름 Equals True")
    void equals() {
        Name name1 = new Name("A");
        Name name2 = new Name("A");

        assertEquals(name1, name2);
    }

    @Test
    @DisplayName("다른 이름 Equals False")
    void not_equals() {
        Name name1 = new Name("A");
        Name name2 = new Name("B");

        assertNotEquals(name1, name2);
    }
}
