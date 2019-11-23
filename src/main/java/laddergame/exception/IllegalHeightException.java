package laddergame.exception;

public class IllegalHeightException extends NumberFormatException {

    public static final String ILLEGAL_HEIGHT_MESSAGE = "올바르지 않은 높이 값입니다.";

    public IllegalHeightException() {
        super(ILLEGAL_HEIGHT_MESSAGE);
    }
}
