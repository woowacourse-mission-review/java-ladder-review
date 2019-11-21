package games.racinggame;

import games.Game;
import games.racinggame.domain.Cars;
import games.racinggame.domain.GameResult;
import games.racinggame.domain.RacingRounds;
import games.racinggame.domain.instructions.RandomMovementInstruction;
import games.racinggame.view.InputView;
import games.racinggame.view.OutputView;

public class RacingGame implements Game {
    private static final String GAME_NAME = "CAR";
    private InputView inputView;
    private OutputView outputView;

    public RacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    @Override
    public boolean isPlayable(String gameName) {
        return GAME_NAME.equals(gameName);
    }

    @Override
    public void start() {
        Cars cars = registerCars();
        RacingRounds racingRounds = registerRacingRounds();
        RandomMovementInstruction movementInstruction = new RandomMovementInstruction();

        GameResult gameResult = racingRounds.doRounds(cars, movementInstruction);
        outputView.printGameResult(gameResult);
    }

    private RacingRounds registerRacingRounds() {
        RacingRounds racingRounds;
        do {
            String rawRacingRounds = inputView.askUserInput("경기횟수를 입력 해 주세요!");
            racingRounds = new RacingRounds(rawRacingRounds);
        } while (racingRounds.isNotSuccessfullyMade());

        return racingRounds;
    }

    private Cars registerCars() {
        Cars cars;
        do {
            String carNames = inputView.askUserInput("자동차 이름을 입력해주세요! 자동차 이름은 쉼표로 구분합니다!");
            cars = new Cars(carNames);
        } while (cars.isNotSuccessfullyMade());

        return cars;
    }
}
