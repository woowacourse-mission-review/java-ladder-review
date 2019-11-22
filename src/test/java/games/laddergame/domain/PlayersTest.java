package games.laddergame.domain;

import games.racinggame.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayersTest {
    @Test
    @DisplayName("플레이어 생성테스트")
    void register_palyers_test() {
        String rawPlayersNames = "java,html,ruby,css,go";
        Players players = new Players(rawPlayersNames);

        assertThat(players.isNotSuccessfullyMade()).isFalse();
        assertThat(players.getPlayerAt(2).getPosition()).isEqualTo(2);
        assertThat(players.getPlayerAt(3).getName()).isEqualTo("css");
    }

    @Test
    @DisplayName("플레이어 생성테스트 오류, 다섯자 이상의 이름")
    void fail_register_palyers_test1() {
        String rawPlayersNames = "javajavajava,html,ruby,css,go";
        Players players = new Players(rawPlayersNames);

        assertThat(players.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("플레이어 생성테스트 오류, 이름이 없는 경우")
    void register_palyers_test2() {
        String rawPlayersNames = "java,,ruby,css,go";
        Players players = new Players(rawPlayersNames);

        assertThat(players.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("플레이어 이름에 중복있을 때 테스트")
    void fail_cars_constructors_tests3() {
        String userInput = "abc,abc,cda";
        Players players = new Players(userInput);
        assertThat(players.isNotSuccessfullyMade()).isTrue();
    }
}