package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import support.StringParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ResultsTest {

    @Test
    @DisplayName("List<String>을 매개변수로 받아 Results 객체를 생성한다.")
    void create_Names() {
        String input = "꽝,5000,꽝,3000";
        List<String> inputs = StringParser.parse(input);

        assertDoesNotThrow(() -> new Results(inputs));
    }
}
