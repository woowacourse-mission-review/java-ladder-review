package games.laddergame.domain;

import games.utility.BaseGameValidityChecker;
import games.utility.CommaParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private List<Player> players;
    private static int STARTING_POSITION = 0;

    public Players(String rawPlayersNames) {
        try {
            List<String> playersNames = CommaParser.parse(rawPlayersNames);
            BaseGameValidityChecker.checkDuplicateCarNames(playersNames);

            int lastPosition = playersNames.size() - 1;
            this.players = IntStream.rangeClosed(STARTING_POSITION, lastPosition)
                    .mapToObj(index -> new Player(playersNames.get(index), index))
                    .collect(Collectors.toList());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            this.players = null;
        }
    }

    public boolean isNotSuccessfullyMade() {
        return players == null;
    }

    public Player getPlayerAt(int index) {
        return players.get(index);
    }
}
