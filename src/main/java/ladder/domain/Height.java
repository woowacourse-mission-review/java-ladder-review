package ladder.domain;

import java.util.Objects;

public class Height {
    static final int HEIGHT_MIN_BOUNDARY = 1;

    private final int height;

    private Height(final int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(final int height) {
        if (height < HEIGHT_MIN_BOUNDARY) {
            throw new IllegalArgumentException("높이는 " + HEIGHT_MIN_BOUNDARY + "이상 이어야 합니다.");
        }
    }

    public static Height from(final int height) {
        return new Height(height);
    }

    int getHeight() {
        return height;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    @Override
    public String toString() {
        return "Height{" +
                "height=" + height +
                '}';
    }
}
