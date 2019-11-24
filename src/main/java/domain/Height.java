package domain;

import domain.exception.InvalidHeightException;

public class Height {
    private static final int NATURAL_NUMBER_BOUNDARY = 0;

    private final int height;

    public Height(String height) {
        try {
            this.height = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new InvalidHeightException();
        }

        validateHeight();
    }

    private void validateHeight() {
        if (height <= NATURAL_NUMBER_BOUNDARY) {
            throw new InvalidHeightException();
        }
    }

    public int getHeight() {
        return height;
    }
}
