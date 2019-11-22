package games.laddergame.domain;


import games.laddergame.exception.InvalidPlayerNameException;
import games.utility.BaseGameValidityChecker;

public class Player {
    private String name;
    private int position;

    public Player(String name, int position) {
        if (BaseGameValidityChecker.isNotValid(name)) {
            throw new InvalidPlayerNameException();
        }
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
