package games.laddergame.domain;


import games.laddergame.exception.InvalidPlayerNameException;
import games.utility.BaseGameValidityChecker;

public class Player implements GameComponent, Comparable<Player> {
    private String name;
    private int position;

    public Player(String name, int position) {
        name = name.trim();
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

    @Override
    public boolean canParticipate(int participantPosition) {
        return position == participantPosition;
    }

    @Override
    public void swapWith(GameComponent otherParticipant) {
        int temporary = position;
        this.position = otherParticipant.getPosition();
        otherParticipant.finalizeSwap(temporary);
    }

    @Override
    public void finalizeSwap(int temporary) {
        this.position = temporary;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(position, o.position);
    }
}
