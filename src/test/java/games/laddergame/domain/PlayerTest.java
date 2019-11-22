package games.laddergame.domain;

import games.laddergame.exception.InvalidPlayerNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    @DisplayName("플레이어 생성테스트 오류, 다섯자 이상의 이름")
    void fail_register_palyers_test1() {
        assertThrows(InvalidPlayerNameException.class, () -> new Player("javajavajava", 100));
    }

    @Test
    @DisplayName("플레이어 생성테스트 오류, 이름이 없는 경우")
    void register_palyers_test2() {
        assertThrows(InvalidPlayerNameException.class, () -> new Player("", 100));
    }
}