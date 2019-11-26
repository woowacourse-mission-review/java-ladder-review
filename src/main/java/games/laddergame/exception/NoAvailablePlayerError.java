package games.laddergame.exception;

public class NoAvailablePlayerError extends RuntimeException {
    private static final String MESSAGE = "그 포지션에 존재하는 선수가 없습니다";

    public NoAvailablePlayerError() {
        super(MESSAGE);
    }
}
