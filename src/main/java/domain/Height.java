package domain;

import domain.exception.InvalidHeightException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Height {
    private static final Pattern pattern = Pattern.compile("^[1-9]+[0-9]*$");

    private final int height;

    public Height(final String heightInput) {
        validate(heightInput);
        height = Integer.parseInt(heightInput);
    }

    private void validate(final String heightInput) {
        Matcher matcher = pattern.matcher(heightInput);
        if (!matcher.find()) {
            throw new InvalidHeightException();
        }
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
}
