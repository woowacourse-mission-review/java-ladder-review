package laddergame.domain.player;

import laddergame.exception.ExcessOfPlayerNameException;

// TODO: 23/11/2019 modify naming to 'LadderPlayerName'
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

    public boolean matchName(final String name) {
        return this.name.match(name);
    }

    public String getName() {
        return name.getInnerName();
    }
}
