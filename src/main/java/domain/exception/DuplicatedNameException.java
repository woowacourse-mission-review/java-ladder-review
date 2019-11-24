package domain.exception;

public class DuplicatedNameException extends RuntimeException{
    private static final String MESSAGE = "사람 이름은 중복될 수 없습니다.";

    public DuplicatedNameException() {
        super(MESSAGE);
    }
}
