package domain;

import domain.exception.EmptyNameException;
import domain.exception.NameLengthExcessException;

public class Name {
    private static final String EMPTY_STRING = "";
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.equals(EMPTY_STRING)) {
            throw new EmptyNameException();
        }

        if (name.length() > MAX_NAME_SIZE) {
            throw new NameLengthExcessException();
        }
    }

    public int length() {
        return name.length();
    }

    public String getName() {
        return name;
    }
}
