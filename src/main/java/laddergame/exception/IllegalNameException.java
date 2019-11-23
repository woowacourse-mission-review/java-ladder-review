package laddergame.exception;

public class IllegalNameException extends IllegalArgumentException {

    public static final String ILLEGAL_NAME_MESSAGE = "이름은 빈 문자열, 공백 등으로 사용하실 수 없습니다.";

    public IllegalNameException() {
        super(ILLEGAL_NAME_MESSAGE);
    }
}
