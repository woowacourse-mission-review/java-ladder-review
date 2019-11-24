package domain;

import domain.exception.DuplicatedNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import support.StringParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NamesTest {

    @Test
    @DisplayName("List<String>을 매개변수로 받아 Names 객체를 생성한다.")
    void create_Names() {
        String input = "pobi,honux,crong,jk";
        List<String> inputs = StringParser.parse(input);

        assertDoesNotThrow(() -> new Names(inputs));
    }

    @Test
    @DisplayName("중복된 이름이 있는 경우 예외가 발생한다.")
    void create_duplicated_names() {
        String input = "pobi,honux,crong,pobi";
        List<String> inputs = StringParser.parse(input);

        assertThrows(DuplicatedNameException.class, () -> new Names(inputs));
    }

    @Test
    @DisplayName("정상적으로 생성된 Names에서 크기를 가져온다.")
    void get_size() {
        String input = "pobi,honux,crong,jk";
        List<String> inputs = StringParser.parse(input);
        Names names =  new Names(inputs);

        assertThat(names.size()).isEqualTo(4);
    }
}
