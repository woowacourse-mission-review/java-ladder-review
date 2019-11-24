package laddergame.domain.ladder.exception;

public class InvalidHeightException extends RuntimeException {

    private static final String INVALID_HEIGHT_MESSAGE = "높이는 1이상이어야 합니다.";

    public InvalidHeightException() {
        super(INVALID_HEIGHT_MESSAGE);
    }
}
