public class RacingGame implements Game {
    private InputAsker inputAsker;

    public RacingGame(InputAsker inputAsker) {
        this.inputAsker = inputAsker;
    }

    @Override
    public void start() {
        String userInput = inputAsker.askInitialUserInput();
        Cars cars = new Cars(userInput);
//        RacingRounds racingRounds = new RacingRounds(userInput);
    }
}
