package ladder.domain.player;

import java.util.Objects;

public class PlayerName {
    private static final int NAME_MIN_BOUNDARY = 1;
    private static final int NAME_MAX_BOUNDARY = 5;

    private final String name;

    private PlayerName(final String name) {
        this.name = Objects.requireNonNull(name).trim();
        validateLength(this.name);
    }

    private void validateLength(final String name) {
        if (name.length() < NAME_MIN_BOUNDARY || name.length() > NAME_MAX_BOUNDARY) {
            throw new IllegalArgumentException(String.format("이름 길이는 %d~%d 사이어야 합니다.", NAME_MIN_BOUNDARY, NAME_MAX_BOUNDARY));
        }
    }

    public static PlayerName from(final String name) {
        return new PlayerName(name);
    }

    public String get() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final PlayerName playerName1 = (PlayerName) o;
        return Objects.equals(name, playerName1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PlayerName{" +
                "name='" + name + '\'' +
                '}';
    }
}
