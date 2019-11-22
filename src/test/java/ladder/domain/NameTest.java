package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameTest {

    @Test
    void 논리적_동치성_확인() {
        Name name1 = Name.from("베디");
        Name name2 = Name.from("베디");

        assertThat(name1).isEqualTo(name2);
        assertThat(name1 == name2).isFalse();
    }

    @Test
    void 공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Name.from(""));
    }

    @Test
    void NULL_예외처리() {
        assertThrows(NullPointerException.class, () -> Name.from(null));
    }

    @Test
    void 유효한_이름_입력_생성_확인() {
        String expected = "베디";
        String actual = Name.from(expected).getName();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이름_공백_제거_확인() {
        // given
        String expected = "베디";
        String withWhiteSpace = " " + expected + "  ";

        // when
        String actual = Name.from(withWhiteSpace).getName();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}