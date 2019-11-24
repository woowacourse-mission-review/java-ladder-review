package laddergame.domain.ladder.exception;

public class InvalidDirectionException extends RuntimeException {

    private static final String INVALID_DIRECTION_MESSAGE = "양쪽 모두 이동 가능한 경우는 존재할 수 없습니다.";

    public InvalidDirectionException() {
        super(INVALID_DIRECTION_MESSAGE);
    }
}
