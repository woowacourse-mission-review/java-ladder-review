package laddergame.domain.player;

import laddergame.exception.IllegalNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    @DisplayName("Name 객체 생성하기")
    void create() {
        Name name = new Name("red");

        assertThat(name.getInnerName()).isEqualTo("red");
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
}