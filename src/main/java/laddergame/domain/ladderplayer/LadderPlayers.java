package laddergame.domain.ladderplayer;

import laddergame.exception.DuplicatePlayersException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderPlayers {

    private final List<LadderPlayer> players;

    private LadderPlayers(final List<LadderPlayer> players) {
        if (hasDuplicatePlayers(players)) {
            throw new DuplicatePlayersException();
        }

        this.players = players;
    }

    private boolean hasDuplicatePlayers(final List<LadderPlayer> players) {
        Set<LadderPlayer> playerSet = new HashSet<>(players);
        return playerSet.size() != players.size();
    }

    public static LadderPlayers create(final List<LadderPlayer> players) {
        return new LadderPlayers(players);
    }

    public int size() {
        return players.size();
    }

    public boolean hasPlayerWithName(final String name) {
        return players.stream()
                .anyMatch(player -> player.matchName(name));
    }
}
