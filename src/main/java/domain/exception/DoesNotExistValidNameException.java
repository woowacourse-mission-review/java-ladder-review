package domain.exception;

public class DoesNotExistValidNameException extends RuntimeException {
    private static final String MESSAGE = "유효하지 않은 이름입니다.";

    public DoesNotExistValidNameException() {
        super(MESSAGE);
    }
}
