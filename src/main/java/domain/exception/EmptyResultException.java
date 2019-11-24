package domain.exception;

public class EmptyResultException extends RuntimeException {
    private static final String MESSAGE = "빈 문자열을 사다리 실행 결과로 입력할 수 없습니다.";

    public EmptyResultException() {
        super(MESSAGE);
    }
}
