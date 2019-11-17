import output.OutputView;
import game.RacingGame;
import input.RacingGameInputAsker;

public class GameLauncher {
    public static void main(String[] args) {
        RacingGameInputAsker inputAsker = new RacingGameInputAsker();
        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame(inputAsker, outputView);
        GameStarter.start(racingGame);
    }
}
