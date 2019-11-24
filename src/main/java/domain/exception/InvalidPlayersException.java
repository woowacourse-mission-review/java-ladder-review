package domain.exception;

public class InvalidPlayersException extends IllegalArgumentException {
    public InvalidPlayersException(final String s) {
        super(s);
    }
}
