package domain;

import domain.exception.DifferentSizeFromNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import support.StringParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultsTest {

    @Test
    @DisplayName("List<String>을 매개변수로 받아 Results 객체를 생성한다.")
    void create_Results() {
        String input = "꽝,5000,꽝,3000";
        List<String> inputs = StringParser.parse(input);

        assertDoesNotThrow(() -> new Results(inputs, 4));
    }

    @Test
    @DisplayName("입력된 사람 이름 개수와 사다리 결과 개수가 다르면 예외가 발생한다.")
    void create_Results_different_name_size() {
        String input = "꽝,5000,꽝,3000";
        List<String> inputs = StringParser.parse(input);

        assertThrows(DifferentSizeFromNameException.class, () -> new Results(inputs, 5));
    }
}
