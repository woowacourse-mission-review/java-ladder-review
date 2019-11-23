package laddergame.exception;

public class MismatchSizeBetweenGoalsAndPlayersException extends IllegalArgumentException {

    public static final String MISMATCH_SIZE_BETWEEN_GOALS_AND_PLAYERS_MESSAGE = "실행 결과의 수는 입력한 참여자의 수와 일치해야 합니다.";

    public MismatchSizeBetweenGoalsAndPlayersException() {
        super(MISMATCH_SIZE_BETWEEN_GOALS_AND_PLAYERS_MESSAGE);
    }
}
