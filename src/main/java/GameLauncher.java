import games.exception.NoSuchGameException;
import games.racinggame.RacingGame;

import java.util.Arrays;
import java.util.List;

public class GameLauncher {
    private static List<Game> games = Arrays.asList(new RacingGame());

    public static void main(String[] args) {
        Game game = selectGame("CAR");
        game.start();
    }

    private static Game selectGame(String gameName) {
        return games.stream()
                .filter(game -> game.isPlayable(gameName))
                .findAny()
                .orElseThrow(NoSuchGameException::new);
    }
}
