package games.laddergame.domain;

import games.laddergame.exception.DoesNotSupportException;

public class Prize implements GameComponent {
    private String name;
    private int position;
    public Prize(String name, int position) {
        name = name.trim();
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
        throw new DoesNotSupportException();
    }

    @Override
    public void swapWith(GameComponent rightParticipant) {
        throw new DoesNotSupportException();
    }

    @Override
    public void finalizeSwap(int temporary) {
        throw new DoesNotSupportException();
    }
}
