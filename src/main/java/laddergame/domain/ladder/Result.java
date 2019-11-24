package laddergame.domain.ladder;

import laddergame.domain.ladder.exception.InvalidResultValueException;
import org.apache.commons.lang3.StringUtils;

public class Result {

    private final String result;

    private Result(final String result) {
        if (StringUtils.isBlank(result)) {
            throw new InvalidResultValueException();
        }
        this.result = result;
    }

    public static Result of(final String result) {
        return new Result(result);
    }

    public String getResult() {
        return result;
    }
}
