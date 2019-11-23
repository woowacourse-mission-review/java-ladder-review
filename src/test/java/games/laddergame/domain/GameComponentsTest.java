package games.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class GameComponentsTest {

    @Test
    @DisplayName("플레이어 생성테스트")
    void register_palyers_test() {
        Player player1 = new Player("jm", 10);
        Player player2 = new Player("im", 11);

        GameComponents players = new GameComponents(Arrays.asList(player1, player2), true);

        assertThat(players.isNotSuccessfullyMade()).isFalse();
        assertThat(players.getComponentAt(0).getPosition()).isEqualTo(10);
        assertThat(players.getComponentAt(1).getName()).isEqualTo("im");
    }


    @Test
    @DisplayName("플레이어 이름에 중복있을 때 테스트")
    void fail_cars_constructors_tests3() {
        Player player1 = new Player("jm", 10);
        Player player2 = new Player("jm", 11);

        GameComponents players = new GameComponents(Arrays.asList(player1, player2), true);

        assertThat(players.isNotSuccessfullyMade()).isTrue();
    }
}