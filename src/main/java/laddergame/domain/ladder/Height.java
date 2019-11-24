package laddergame.domain.ladder;

import laddergame.domain.ladder.exception.InvalidHeightException;

public class Height {

    private static final int MIN_LADDER_HEIGHT = 1;
    private final int height;

    private Height(final int height) {
        if (!isValidHeight(height)) {
            throw new InvalidHeightException();
        }
        this.height = height;
    }

    public static Height of(final int height) {
        return new Height(height);
    }

    private boolean isValidHeight(final int height) {
        return height >= MIN_LADDER_HEIGHT;
    }

    public int getHeight() {
        return height;
    }
}
