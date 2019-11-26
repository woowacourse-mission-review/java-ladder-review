package games.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {
    @Test
    void racingRounds_constructor_test() {
        String userInput = "7";
        Height height = new Height(userInput);
        assertThat(height.getHeight()).isEqualTo(7);
    }

    @Test
    @DisplayName("숫자가 아닐 때")
    void fail_racingRounds_constructor_test1() {
        String userInput = "H";
        Height height = new Height(userInput);
        assertThat(height.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("음수일 때")
    void fail_racingRounds_constructor_test2() {
        String userInput = "-1";
        Height height = new Height(userInput);
        assertThat(height.isNotSuccessfullyMade()).isTrue();
    }

    @Test
    @DisplayName("인풋이 비어있을 때")
    void fail_racingRounds_constructor_test3() {
        String userInput = "";
        Height height = new Height(userInput);
        assertThat(height.isNotSuccessfullyMade()).isTrue();
    }
}