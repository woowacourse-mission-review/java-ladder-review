package ghostleg;

public class Position {
    private static final int MIN_POSITION = 0;

    private int position;
    private final NumOfPlayers numOfPlayers;

    public Position(int position, NumOfPlayers numOfPlayers) {
        validatePosition(position, numOfPlayers);
        this.position = position;
        this.numOfPlayers = numOfPlayers;
    }

    private void validatePosition(int position, NumOfPlayers numOfPlayers) {
        if (position < MIN_POSITION || position >= numOfPlayers.getValue()) {
            throw new IllegalArgumentException(String.format("플레이어의 위치는 %d 이상, %d(플레이어의 수) 미만이여야 합니다.",
                    MIN_POSITION, numOfPlayers.getValue()));
        }
    }

    public void add(int next) {
        validatePosition(position + next, numOfPlayers);
        position += next;
    }

    public int getValue() {
        return position;
    }
}
