import games.Game;
import games.racinggame.output.OutputView;
import games.racinggame.RacingGame;
import games.racinggame.input.RacingGameInputAsker;

import java.util.Arrays;
import java.util.List;

public class GameLauncher {
    private List<Game> games = Arrays.asList(new RacingGame());

    public static void main(String[] args) {
        RacingGameInputAsker inputAsker = new RacingGameInputAsker();
        OutputView outputView = new OutputView();
        RacingGame racingGame = new RacingGame(inputAsker, outputView);
        GameStarter.start(racingGame);
    }
}
