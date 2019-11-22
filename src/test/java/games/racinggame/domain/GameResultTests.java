package games.racinggame.domain;

import games.racinggame.domain.instructions.SimpleMovementInstruction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTests {
    @Test
    void game_results_test() {
        String carNames = "abc,bbc,abf";
        String rawRacingRounds = "2";
        Cars cars = new Cars(carNames);
        RacingRounds racingRounds = new RacingRounds(rawRacingRounds);
        SimpleMovementInstruction movementInstructions = new SimpleMovementInstruction();

        GameResult gameResult = racingRounds.doRounds(cars, movementInstructions);

        List<CarStatusSnapShot> snapShots = new ArrayList<>();
        CarStatusSnapShot carStatusSnapShot1 = new CarStatusSnapShot(Arrays.asList("abc", "bbc", "abf"), Arrays.asList(0, 0, 0));
        CarStatusSnapShot carStatusSnapShot2 = new CarStatusSnapShot(Arrays.asList("abc", "bbc", "abf"), Arrays.asList(0, 0, 0));
        snapShots.add(carStatusSnapShot1);
        snapShots.add(carStatusSnapShot2);

        List<String> winners = new ArrayList<>(Arrays.asList("abc", "bbc", "abf"));

        GameResult checkGameResult = new GameResult(snapShots, winners);

        assertThat(gameResult.getSnapShots().size()).isEqualTo(2);
        assertThat(gameResult).isEqualTo(checkGameResult);
    }

    @Test
    void game_results_test2() {
        String carNames = "abc,bbc,abf";
        String rawRacingRounds = "2";
        Cars cars = new Cars(carNames);
        RacingRounds racingRounds = new RacingRounds(rawRacingRounds);

        GameResult gameResult = racingRounds.doRounds(cars, () -> 9);

        List<CarStatusSnapShot> snapShots = new ArrayList<>();
        CarStatusSnapShot carStatusSnapShot1 = new CarStatusSnapShot(Arrays.asList("abc", "bbc", "abf"), Arrays.asList(1, 1, 1));
        CarStatusSnapShot carStatusSnapShot2 = new CarStatusSnapShot(Arrays.asList("abc", "bbc", "abf"), Arrays.asList(2, 2, 2));
        snapShots.add(carStatusSnapShot1);
        snapShots.add(carStatusSnapShot2);

        List<String> winners = new ArrayList<>(Arrays.asList("abc", "bbc", "abf"));

        GameResult checkGameResult = new GameResult(snapShots, winners);

        assertThat(gameResult.getSnapShots().size()).isEqualTo(2);
        assertThat(gameResult).isEqualTo(checkGameResult);
    }

    @Test
    void game_results_test3() {
        Car car1 = new Car("jm", 100);
        Car car2 = new Car("im", 50);
        Car car3 = new Car("gm", 5);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        String rawRacingRounds = "2";
        RacingRounds racingRounds = new RacingRounds(rawRacingRounds);

        GameResult gameResult = racingRounds.doRounds(cars, () -> 9);

        List<CarStatusSnapShot> snapShots = new ArrayList<>();
        CarStatusSnapShot carStatusSnapShot1 = new CarStatusSnapShot(Arrays.asList("jm", "im", "gm"), Arrays.asList(101, 51, 6));
        CarStatusSnapShot carStatusSnapShot2 = new CarStatusSnapShot(Arrays.asList("jm", "im", "gm"), Arrays.asList(102, 52, 7));
        snapShots.add(carStatusSnapShot1);
        snapShots.add(carStatusSnapShot2);

        List<String> winners = new ArrayList<>(Collections.singletonList(car1.getCarName()));

        GameResult checkGameResult = new GameResult(snapShots, winners);

        assertThat(gameResult.getSnapShots().size()).isEqualTo(2);
        assertThat(gameResult).isEqualTo(checkGameResult);
        assertThat(gameResult.findWinners()).isEqualTo(winners);
    }
}
