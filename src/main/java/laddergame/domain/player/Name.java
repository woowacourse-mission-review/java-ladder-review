package laddergame.domain.player;

import laddergame.exception.IllegalNameException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Name {

    private final String innerName;

    public Name(final String innerName) {
        if (StringUtils.isBlank(innerName)) {
            throw new IllegalNameException();
        }

        this.innerName = innerName;
    }

    public boolean match(final String name) {
        return innerName.equals(name);
    }

    public String getInnerName() {
        return innerName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name = (Name) o;
        return Objects.equals(innerName, name.innerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerName);
    }
}
