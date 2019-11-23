package games.laddergame.exception;

public class DoesNotSupportException extends RuntimeException {
    private static final String MESSAGE = "본 객체는 자리바꾸기에 참여할 수 없는 객체입니다!";

    public DoesNotSupportException() {
        super(MESSAGE);
    }
}
