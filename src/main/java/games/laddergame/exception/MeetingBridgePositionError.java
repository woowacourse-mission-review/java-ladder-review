package games.laddergame.exception;

public class MeetingBridgePositionError extends RuntimeException {
    private static final String MESSAGE = "사다리리의 자리는 1부터 시작입니다!";

    public MeetingBridgePositionError() {
        super(MESSAGE);
    }
}
