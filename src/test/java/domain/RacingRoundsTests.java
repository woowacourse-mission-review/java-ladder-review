package domain;

import domain.RacingRounds;
import game.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void do_rounds_test() {
        String userInput = "abc,bbc,abf%&%2";
        Cars cars = new Cars(userInput);
        RacingRounds racingRounds = new RacingRounds(userInput);
        SimpleMovementInstruction movementInstructions = new SimpleMovementInstruction();

        GameResult gameResult = racingRounds.doRounds(cars, movementInstructions);

        List<CarStatusSnapShot> snapShots = new ArrayList<>();
        CarStatusSnapShot carStatusSnapShot1 = new CarStatusSnapShot(Arrays.asList("abc", "bbc", "abf"), Arrays.asList(0,0,0));
        CarStatusSnapShot carStatusSnapShot2 = new CarStatusSnapShot(Arrays.asList("abc","bbc","abf"), Arrays.asList(0,0,0));
        snapShots.add(carStatusSnapShot1);
        snapShots.add(carStatusSnapShot2);

        GameResult checkGameResult = new GameResult(snapShots);

        assertThat(gameResult.getSnapShots().size()).isEqualTo(2);
        assertThat(gameResult).isEqualTo(checkGameResult);
    }
}
