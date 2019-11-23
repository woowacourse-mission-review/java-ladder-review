package ladder.domain.player;

import ladder.domain.Position;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(final PlayerName name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Player of(final PlayerName name, final Position position) {
        return new Player(name, position);
    }

    public String getName() {
        return name.get();
    }

    public Position getPosition() {
        return position;
    }
}
