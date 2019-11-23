package laddergame.domain.name;

import laddergame.exception.IllegalNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    private Name name;

    @BeforeEach
    void setUp() {
        name = new Name("red");
    }

    @Test
    @DisplayName("Name 객체 생성하기")
    void create() {
        assertThat(name.getInnerName()).isEqualTo("red");
    }

    @Test
    void equals() {
        assertThat(name).isEqualTo(new Name("red"));
    }

    @Test
    void create_IllegalNameException() {
        assertThrows(IllegalNameException.class, () -> new Name(""));
        assertThrows(IllegalNameException.class, () -> new Name(" "));
        assertThrows(IllegalNameException.class, () -> new Name(null));
    }

    @Test
    void create_IllegalNameException_message() {
        Exception exception = assertThrows(IllegalNameException.class, () -> new Name(""));

        assertThat(exception.getMessage()).isEqualTo(IllegalNameException.ILLEGAL_NAME_MESSAGE);
    }

    @Test
    void match() {
        assertThat(name.match("red")).isTrue();
        assertThat(name.match("blue")).isFalse();
    }
}