package laddergame.domain.user.exception;

public class InvalidPositionException extends RuntimeException {

    private static final String INVALID_POSITION_MESSAGE = "Position은 0이상이어야 합니다.";

    public InvalidPositionException() {
        super(INVALID_POSITION_MESSAGE);
    }
}
