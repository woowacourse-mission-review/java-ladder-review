package domain;

import java.util.Objects;

public class Player {
    private Name name;

    public Player(final String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
