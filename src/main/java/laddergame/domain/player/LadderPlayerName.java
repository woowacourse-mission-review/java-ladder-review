package laddergame.domain.player;

import laddergame.exception.ExcessOfPlayerNameException;

public class LadderPlayerName {

    public static final int MAX_LEN_OF_PLAYER_NAME = 5;

    private final Name name;

    public LadderPlayerName(final String name) {
        if (isNameExceedMaxLength(name)) {
            throw new ExcessOfPlayerNameException();
        }

        this.name = new Name(name);
    }

    private boolean isNameExceedMaxLength(final String name) {
        return name.length() > MAX_LEN_OF_PLAYER_NAME;
    }

    public boolean matchName(final String name) {
        return this.name.match(name);
    }

    public String getName() {
        return name.getInnerName();
    }
}
