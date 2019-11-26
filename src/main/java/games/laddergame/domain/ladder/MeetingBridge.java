package games.laddergame.domain.ladder;

import games.laddergame.domain.GameComponent;
import games.laddergame.domain.GameComponents;
import games.laddergame.exception.MeetingBridgePositionError;

import java.util.List;

public class MeetingBridge {
    private static final int MINIMUM_POSITION = 1;
    private final int position;
    private final boolean swap;

    public MeetingBridge(int position, boolean swap) {
        if (position < MINIMUM_POSITION) {
            throw new MeetingBridgePositionError();
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
        return "MeetingBridge{" + "swap= " + swap + "}";
    }
}
