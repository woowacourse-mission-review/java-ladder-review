package domain.exception;

public class NameLengthExcessException extends RuntimeException {
    private static final String MESSAGE = "사람 이름은 5글자를 초과할 수 없습니다.";

    public NameLengthExcessException() {
        super(MESSAGE);
    }
}
