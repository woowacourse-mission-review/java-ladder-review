package games.laddergame.domain;


import games.laddergame.exception.InvalidPlayerNameException;
import games.utility.BaseGameValidityChecker;

public class Player implements GameComponent {
    private String name;
    private int position;

    public Player(String name, int position) {
        if (BaseGameValidityChecker.isNotValid(name)) {
            throw new InvalidPlayerNameException();
        }
        this.name = name;
        this.position = position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
