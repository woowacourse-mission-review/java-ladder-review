package laddergame.exception;

import laddergame.domain.player.LadderPlayerName;

public class ExcessOfPlayerNameException extends IllegalArgumentException {

    public static final String EXCESS_OF_PLAYER_NAME_MESSAGE
            = "사용자의 이름 길이는 최대 " + LadderPlayerName.MAX_LEN_OF_PLAYER_NAME + "자입니다.";

    public ExcessOfPlayerNameException() {
        super(EXCESS_OF_PLAYER_NAME_MESSAGE);
    }
}
