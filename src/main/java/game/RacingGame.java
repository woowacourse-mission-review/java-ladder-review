package game;

import domain.Cars;
import domain.RacingRounds;
import domain.instructions.RandomMovementInstruction;
import input.InputAsker;
import output.OutputView;

public class RacingGame implements Game {
    private InputAsker inputAsker;
    private OutputView outputView;

    public RacingGame(InputAsker inputAsker, OutputView outputView) {
        this.inputAsker = inputAsker;
        this.outputView = outputView;
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
        outputView.view(gameResult);
    }
}
