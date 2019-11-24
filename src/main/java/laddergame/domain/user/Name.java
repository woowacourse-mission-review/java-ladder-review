package laddergame.domain.user;

import laddergame.domain.user.exception.InvalidNameSizeException;
import org.apache.commons.lang3.StringUtils;

public class Name {

    private static final int MAX_NAME_SIZE = 5;
    private final String name;

    private Name(final String name) {
        if (isInvalidName(name)) {
            throw new InvalidNameSizeException();
        }
        this.name = name;
    }

    private boolean isInvalidName(final String name) {
        return StringUtils.isBlank(name) || name.length() > MAX_NAME_SIZE;
    }

    public static Name of(final String name) {
        return new Name(name);
    }
}
