package laddergame.domain.player;

// TODO: 23/11/2019 modify naming to 'LadderPlayer'
public class Player {

    private final PlayerName playerName;

    private Player(final String name) {
        this.playerName = new PlayerName(name);
    }

    // TODO: 23/11/2019 modify naming
    public static Player of(String name) {
        return new Player(name);
    }

    public boolean matchName(final String name) {
        return playerName.matchName(name);
    }

    public String getPlayerName() {
        return playerName.getName();
    }
}
