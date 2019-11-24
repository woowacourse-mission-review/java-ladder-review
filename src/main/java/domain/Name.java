package domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
