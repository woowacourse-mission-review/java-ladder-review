package game;

import domain.Cars;
import domain.RacingRounds;
import domain.RandomMovementInstruction;
import input.InputAsker;

public class RacingGame implements Game {
    private InputAsker inputAsker;

    public RacingGame(InputAsker inputAsker) {
        this.inputAsker = inputAsker;
    }

    @Override
    public void start() {
        Cars cars;
        RacingRounds racingRounds;

        do {
            String userInput = inputAsker.askInitialUserInput();
            cars = new Cars(userInput);
            racingRounds = new RacingRounds(userInput);
        } while(cars.isNotSucessfullyMade() || racingRounds.isNotSuccesfullyMade());

        RandomMovementInstruction movementInstruction = new RandomMovementInstruction();
        GameResult gameResult = racingRounds.doRounds(cars, movementInstruction);
    }
}
