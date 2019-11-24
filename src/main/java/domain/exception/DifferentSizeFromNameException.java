package domain.exception;

public class DifferentSizeFromNameException extends RuntimeException {
    private static final String MESSAGE = "사다리 결과의 개수는 입력된 사람 이름 개수와 다를 수 없습니다.";

    public DifferentSizeFromNameException() {
        super(MESSAGE);
    }
}
