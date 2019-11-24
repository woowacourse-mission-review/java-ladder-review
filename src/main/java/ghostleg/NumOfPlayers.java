package ghostleg;

public class NumOfPlayers {
    private static final int MIN_NUM_OF_PLAYERS = 2;
    private static final int MAX_NUM_OF_PLAYERS = 100;
    private final int numOfPlayers;

    public NumOfPlayers(int numOfPlayers) {
        validateNumOfPlayers(numOfPlayers);
        this.numOfPlayers = numOfPlayers;
    }

    private void validateNumOfPlayers(int numOfPlayers) {
        if (numOfPlayers < MIN_NUM_OF_PLAYERS || numOfPlayers > MAX_NUM_OF_PLAYERS) {
            throw new IllegalArgumentException(String.format("플레이어의 수는 최소 %d 명 이상, 최대 %d 명 이하여야 합니다.", MIN_NUM_OF_PLAYERS, MAX_NUM_OF_PLAYERS));
        }
    }

    public int getValue() {
        return numOfPlayers;
    }
}
