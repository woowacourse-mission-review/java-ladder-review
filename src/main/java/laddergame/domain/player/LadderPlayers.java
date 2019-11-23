package laddergame.domain.player;

import java.util.List;

public class LadderPlayers {

    private final List<LadderPlayer> players;

    private LadderPlayers(final List<LadderPlayer> players) {
        this.players = players;
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
