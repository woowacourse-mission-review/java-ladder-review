package domain;

public class Name {
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new NameLengthExcessException();
        }
    }

    public String getName() {
        return name;
    }
}
