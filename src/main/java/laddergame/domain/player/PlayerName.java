package laddergame.domain.player;

import laddergame.exception.ExcessOfPlayerNameException;

public class PlayerName {

    public static final int MAX_LEN_OF_PLAYER_NAME = 5;

    private final Name name;

    public PlayerName(final String name) {
        if (isNameExceedMaxLength(name)) {
            throw new ExcessOfPlayerNameException();
        }

        this.name = new Name(name);
    }

    private boolean isNameExceedMaxLength(final String name) {
        return name.length() > MAX_LEN_OF_PLAYER_NAME;
    }

    public String getName() {
        return name.getInnerName();
    }
}
