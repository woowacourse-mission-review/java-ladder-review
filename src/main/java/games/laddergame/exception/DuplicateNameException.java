package games.laddergame.exception;

public class DuplicateNameException extends RuntimeException {
    private static final String MESSAGE = "이름에 중복이 있습니다!";

    public DuplicateNameException() {
        super(MESSAGE);
    }
}
