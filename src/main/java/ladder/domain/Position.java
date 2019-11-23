package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    public static final int MIN_POSITION_BOUNDARY = 0;
    static final int POSITION_CACHE_SIZE = 3;

    private static final Map<Integer, Position> CACHE = new HashMap<>();

    static {
        for (int i = MIN_POSITION_BOUNDARY; i <= POSITION_CACHE_SIZE; i++) {
            CACHE.put(i, new Position(i));
        }
    }

    private final int position;

    private Position(final int position) {
        validate(position);
        this.position = position;
        CACHE.put(position, this);
    }

    private void validate(final int position) {
        if (position < MIN_POSITION_BOUNDARY) {
            throw new IllegalArgumentException("포지션은 " + MIN_POSITION_BOUNDARY + "이상이어야 합니다.");
        }
    }

    public static Position from(final int position) {
        // TODO: 2019/11/23 소름 돋는다.. 왜 value가 있어도 default가 실행되지??....
//        return CACHE.getOrDefault(position, new Position(position));
        final Position value = CACHE.get(position);
        return value != null ? value : new Position(position);
    }

    public Position change(final int direction) {
        return from(this.position + direction);
    }

    public int get() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
