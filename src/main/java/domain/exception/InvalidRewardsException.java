package domain.exception;

public class InvalidRewardsException extends IllegalArgumentException {
    public InvalidRewardsException(final String s) {
        super(s);
    }
}
