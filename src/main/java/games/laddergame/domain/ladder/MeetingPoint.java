package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponent;
import games.laddergame.domain.GameComponents;

import java.util.List;

public class MeetingPoint {
    private final int position;
    private final boolean swap;

    public MeetingPoint(int position, boolean swap) {
        if (position < 1) {
            throw new IllegalArgumentException();
        }
        this.position = position;
        this.swap = swap;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSwap() {
        return swap;
    }

    public void swap(GameComponents players) {
        if (swap) {
            List<GameComponent> participants = players.collectParticipants(position);
            GameComponent leftParticipant = participants.get(0);
            GameComponent rightParticipant = participants.get(1);

            leftParticipant.swapWith(rightParticipant);
        }
    }

    @Override
    public String toString() {
        return "MeetingPoint{" + "swap= " + swap + "}";
    }
}
