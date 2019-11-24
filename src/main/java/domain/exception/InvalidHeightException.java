package domain.exception;

public class InvalidHeightException extends IllegalArgumentException {
    private static final String INVALID_HEIGHT_MESSAGE = "1 이상 정수를 입력해주세요.";

    public InvalidHeightException() {
        super(INVALID_HEIGHT_MESSAGE);
    }
}
