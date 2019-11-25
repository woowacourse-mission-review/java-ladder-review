package laddergame.exception;

import laddergame.domain.ladderplayer.LadderPlayers;

public class LackOfPlayersException extends IllegalArgumentException {

    public static final String LACK_OF_PLAYERS_MESSAGE
            = "참여할 사람의 수는 " + LadderPlayers.MIN_NUM_OF_LADDER_PLAYERS + "명 이상입니다.";

    public LackOfPlayersException() {
        super(LACK_OF_PLAYERS_MESSAGE);
    }
}
