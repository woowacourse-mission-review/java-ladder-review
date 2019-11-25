package laddergame.exception;

public class DuplicatePlayersException extends IllegalArgumentException {

    public static final String DUPLICATE_PLAYERS_MESSAGE = "중복되는 이름이 있습니다.";

    public DuplicatePlayersException() {
        super(DUPLICATE_PLAYERS_MESSAGE);
    }
}
