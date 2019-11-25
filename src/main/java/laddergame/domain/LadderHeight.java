package laddergame.domain;

import laddergame.exception.IllegalHeightException;
import laddergame.exception.LackOfHeightException;

import java.util.Objects;

public class LadderHeight {

    public static final int MIN_HEIGHT = 1;

    private final int height;

    private LadderHeight(final int height) {
        if (isLessThan(height)) {
            throw new LackOfHeightException();
        }

        this.height = height;
    }

    private boolean isLessThan(final int height) {
        return height < MIN_HEIGHT;
    }

    public static LadderHeight from(final int height) {
        return new LadderHeight(height);
    }

    public static LadderHeight from(final String height) {
        try {
            return from(Integer.parseInt(height));
        } catch (NumberFormatException e) {
            throw new IllegalHeightException();
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
