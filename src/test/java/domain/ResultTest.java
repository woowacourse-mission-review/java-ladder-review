package domain;

import domain.exception.EmptyResultException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultTest {
    private static final String NORMAL_RESULT = "꽝";
    private static final String EMPTY_RESULT = "";
    private static final int NORMAL_RESULT_LENGTH = 1;

    @Test
    @DisplayName("사다리 결과를 정상적으로 생성한다.")
    void create_result() {
        Result result = new Result(NORMAL_RESULT);
        assertThat(result.getResult()).isEqualTo(NORMAL_RESULT);
        assertThat(result.length()).isEqualTo(NORMAL_RESULT_LENGTH);
    }

    @Test
    @DisplayName("빈 문자열로 사다리 결과를 생성할 때 예외가 발생한다.")
    void create_empty_result() {
        assertThrows(EmptyResultException.class, () -> new Result(EMPTY_RESULT));
    }
}
