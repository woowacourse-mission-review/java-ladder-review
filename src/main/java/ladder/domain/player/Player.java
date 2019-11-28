package ladder.domain.player;

import ladder.domain.common.Position;

import java.util.Objects;

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

    public boolean matchPlayerName(final String other) {
        return name.get().equals(other);
    }

    public String getName() {
        return name.get();
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
