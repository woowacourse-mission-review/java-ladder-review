package games.laddergame.exception;

public class InvalidPlayerNameException extends RuntimeException {
    private static final String MESSAGE = "플레이어이름중 잘못이 있습니다";

    public InvalidPlayerNameException() {
        super(MESSAGE);
    }
}
