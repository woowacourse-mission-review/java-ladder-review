package games.racinggame.exception;

public class InvalidCarNameException extends RuntimeException {
    private static final String MESSAGE = "자동차 이름이 잘못되었습니다!";

    public InvalidCarNameException() {
    super(MESSAGE);
    }
}
