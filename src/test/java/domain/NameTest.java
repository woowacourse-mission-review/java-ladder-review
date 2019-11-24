package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {
    private static final String NORMAL_NAME = "comac";
    private static final String ERROR_NAME = "abcdefg";

    @Test
    @DisplayName("사람 이름을 정상적으로 생성한다.")
    void create_name() {
        Name name = new Name(NORMAL_NAME);
        assertThat(name.getName()).isEqualTo(NORMAL_NAME);
    }

    @Test
    @DisplayName("5글자를 초과하는 이름을 생성할 때 예외가 발생한다.")
    void create_over_size_name() {
        assertThrows(NameLengthExcessException.class, () -> new Name(ERROR_NAME));
    }
}
