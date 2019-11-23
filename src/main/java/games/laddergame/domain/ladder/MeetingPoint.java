package games.laddergame.domain.ladder;

public class MeetingPoint {
    private final int position;
    private final boolean swapOrNot;

    public MeetingPoint(int position, boolean swapOrNot) {
        if (position < 1) {
            throw new IllegalArgumentException();
        }
        this.position = position;
        this.swapOrNot = swapOrNot;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSwapOrNot() {
        return swapOrNot;
    }
}
