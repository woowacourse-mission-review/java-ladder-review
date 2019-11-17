import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingRoundsTests {
    @Test
    void racingRounds_constructor_test() {
        String userInput = "ffc,abc,cda%&%7";
        RacingRounds racingRounds = new RacingRounds(userInput);
        assertThat(racingRounds.getRounds()).isEqualTo(7);
    }

    @Test
    @DisplayName("숫자가 아닐 때")
    void fail_racingRounds_constructor_test1() {
        String userInput = "ffc,abc,cda%&%H";
        RacingRounds racingRounds = new RacingRounds(userInput);
        assertThat(racingRounds.isNotSuccesfullyMade()).isTrue();
    }

    @Test
    @DisplayName("인풋이 비어있을 때")
    void fail_racingRounds_constructor_test2() {
        String userInput = "ffc,abc,cda%&%";
        RacingRounds racingRounds = new RacingRounds(userInput);
        assertThat(racingRounds.isNotSuccesfullyMade()).isTrue();
    }
}
