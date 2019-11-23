package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerNameTest {

    @Test
    void 논리적_동치성_확인() {
        PlayerName playerName1 = PlayerName.from("베디");
        PlayerName playerName2 = PlayerName.from("베디");

        assertThat(playerName1).isEqualTo(playerName2);
        assertThat(playerName1 == playerName2).isFalse();
    }

    @Test
    void 공백_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> PlayerName.from(""));
    }

    @Test
    void NULL_예외처리() {
        assertThrows(NullPointerException.class, () -> PlayerName.from(null));
    }

    @Test
    void 유효한_이름_입력_생성_확인() {
        String expected = "베디";
        String actual = PlayerName.from(expected).get();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이름_공백_제거_확인() {
        // given
        String expected = "베디";
        String withWhiteSpace = " " + expected + "  ";

        // when
        String actual = PlayerName.from(withWhiteSpace).get();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}