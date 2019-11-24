package laddergame.domain.ladderplayer;

import laddergame.exception.DuplicatePlayersException;
import laddergame.exception.LackOfPlayersException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LadderPlayers {

    public static final int MIN_NUM_OF_LADDER_PLAYERS = 2;

    private final List<LadderPlayer> players;

    private LadderPlayers(final List<LadderPlayer> players) {
        validatePlayers(players);

        this.players = players;
    }

    private void validatePlayers(final List<LadderPlayer> players) {
        if (isLackOfPlayers(players)) {
            throw new LackOfPlayersException();
        }
        if (hasDuplicatePlayers(players)) {
            throw new DuplicatePlayersException();
        }
    }

    private boolean isLackOfPlayers(final List<LadderPlayer> players) {
        return players.size() < MIN_NUM_OF_LADDER_PLAYERS;
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

    public List<String> getAlignedPlayerNames() {
        return players.stream()
                .map(LadderPlayer::getAlignedName)
                .collect(Collectors.toList());
    }
}
