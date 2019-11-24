package domain;

import domain.exception.EmptyResultException;

public class Result {
    private final String result;

    public Result(String result) {
        validateResult(result);
        this.result = result;
    }

    private void validateResult(String result) {
        if (result.equals("")) {
            throw new EmptyResultException();
        }
    }

    public String getResult() {
        return result;
    }
}
