package view.exception;

public class RepeatCountExceedException extends RuntimeException {
    private static final String MESSAGE = "최대 입력 시도 횟수를 초과했습니다. 프로그램이 종료됩니다.";

    public RepeatCountExceedException() {
        super(MESSAGE);
    }
}
