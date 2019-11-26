package games;

import games.exception.NoSuchGameException;
import games.laddergame.LadderGame;
import games.racinggame.RacingGame;

import java.util.Arrays;
import java.util.List;

public class GameLauncher {
    private static List<Game> games = Arrays.asList(new RacingGame(), new LadderGame());

    public static void main(String[] args) {
        Game game = selectGame("LADDER");
        game.start();
    }

    private static Game selectGame(String gameName) {
        return games.stream()
                .filter(game -> game.isPlayable(gameName))
                .findAny()
                .orElseThrow(NoSuchGameException::new);
    }
}
