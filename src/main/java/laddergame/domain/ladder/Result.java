package laddergame.domain.ladder;

import laddergame.domain.ladder.exception.InvalidResultValueException;
import laddergame.domain.user.Position;
import org.apache.commons.lang3.StringUtils;

public class Result {

    private final String result;
    private final Position position;

    private Result(final String result, final int position) {
        if (StringUtils.isBlank(result)) {
            throw new InvalidResultValueException();
        }
        this.result = result;
        this.position = Position.of(position);
    }

    public static Result of(final String result, final int position) {
        return new Result(result, position);
    }
}
