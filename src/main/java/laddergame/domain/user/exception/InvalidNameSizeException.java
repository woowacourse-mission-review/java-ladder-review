package laddergame.domain.user.exception;

public class InvalidNameSizeException extends RuntimeException {

    private static final String INVALID_NAME_SIZE_MESSAGE = "이름은 1~5글자이어야 합니다.";

    public InvalidNameSizeException() {
        super(INVALID_NAME_SIZE_MESSAGE);
    }
}
