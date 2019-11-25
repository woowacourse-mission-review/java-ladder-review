package laddergame.exception;

import laddergame.domain.name.LadderPlayerName;

public class ExcessOfGoalNameException extends IllegalArgumentException {

    public static final String EXCESS_OF_GOAL_NAME_MESSAGE
            = "실행 결과의 길이는 최대 " + LadderPlayerName.MAX_LEN_OF_PLAYER_NAME + "자입니다.";

    public ExcessOfGoalNameException() {
        super(EXCESS_OF_GOAL_NAME_MESSAGE);
    }
}
