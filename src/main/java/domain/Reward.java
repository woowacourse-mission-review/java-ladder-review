package domain;

import java.util.Objects;

public class Reward {
    private final Name name;

    public Reward(final String name) {
        this.name = new Name(name);
    }

    public String getReward() {
        return name.getName();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Reward reward = (Reward) o;
        return name.equals(reward.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
