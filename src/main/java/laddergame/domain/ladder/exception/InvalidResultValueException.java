package laddergame.domain.ladder.exception;

public class InvalidResultValueException extends RuntimeException {

    private static final String INVALID_RESULT_VALUE_MESSAGE = "실행 결과 값이 올바르지 않습니다.";

    public InvalidResultValueException() {
        super(INVALID_RESULT_VALUE_MESSAGE);
    }
}
