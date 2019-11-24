package domain.exception;

public class PlayerNotFoundException extends IllegalArgumentException {
    private static final String PLAYER_NOT_FOUND_MESSAGE = "해당 이름의 참가자가 존재하지 않습니다.";

    public PlayerNotFoundException() {
        super(PLAYER_NOT_FOUND_MESSAGE);
    }
}
