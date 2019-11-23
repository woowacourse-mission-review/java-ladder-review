package ladder.domain.reward;

import ladder.domain.common.Position;

public class Reward {
    private final String name;
    private final Position position;

    private Reward(final String name, final Position position) {
        this.name = name.trim();
        this.position = position;
    }

    public static Reward of(final String name, final Position position) {
        return new Reward(name, position);
    }

    public String getName() {
        return name;
    }

    public boolean matchPosition(final Position other) {
        return position == other;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
