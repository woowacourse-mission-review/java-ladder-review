package laddergame.domain.player;

import java.util.List;

public class Players {

    private final List<Player> players;

    private Players(final List<Player> players) {
        this.players = players;
    }

    public static Players create(final List<Player> players) {
        return new Players(players);
    }

    public int size() {
        return players.size();
    }

    public boolean hasPlayerWithName(final String name) {
        return players.stream()
                .anyMatch(player -> player.matchName(name));
    }
}
