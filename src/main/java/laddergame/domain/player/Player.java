package laddergame.domain.player;

public class Player {

    private final PlayerName name;

    private Player(final String name) {
        this.name = new PlayerName(name);
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public String getName() {
        return name.getName();
    }
}
