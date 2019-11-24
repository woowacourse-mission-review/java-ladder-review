package domain.exception;

public class EmptyNameException extends RuntimeException {
    private static final String MESSAGE = "빈 문자를 이름으로 사용할 수 없습니다.";

    public EmptyNameException() {
        super(MESSAGE);
    }
}
