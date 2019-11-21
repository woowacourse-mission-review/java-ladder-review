package games.exception;

public class NoSuchGameException extends RuntimeException {
    private static final String MESSAGE = "그런 게임은 존재하지 않아!";

    public NoSuchGameException() {
        super(MESSAGE);
    }
}
