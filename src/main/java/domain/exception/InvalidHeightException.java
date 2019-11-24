package domain.exception;

public class InvalidHeightException extends RuntimeException {
    private static final String MESSAGE = "사다리 높이는 자연수만 입력할 수 있습니다.";

    public InvalidHeightException() {
        super(MESSAGE);
    }
}
