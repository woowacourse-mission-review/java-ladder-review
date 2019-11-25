package laddergame.exception;

public class PlayerResultNotFoundException extends IllegalArgumentException {

    public static final String PLAYER_RESULT_NOT_FOUND_MESSAGE = "현재 존재하지 않는 사용자 이름입니다.";

    public PlayerResultNotFoundException() {
        super(PLAYER_RESULT_NOT_FOUND_MESSAGE);
    }
}
