package laddergame.domain.player;

import laddergame.exception.IllegalNameException;
import org.apache.commons.lang3.StringUtils;

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
}
