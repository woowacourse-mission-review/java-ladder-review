import java.util.Optional;

public class RacingGame implements Game {
    private InputAsker inputAsker;

    public RacingGame(InputAsker inputAsker) {
        this.inputAsker = inputAsker;
    }

    @Override
    public void start() {
        Cars cars;
        RacingRounds racingRounds = null;

        do {
            String userInput = inputAsker.askInitialUserInput();
            cars = new Cars(userInput);
//            RacingRounds racingRounds = new RacingRounds(userInput);
        } while(cars.isNotSucessfullyMade());


    }
}
