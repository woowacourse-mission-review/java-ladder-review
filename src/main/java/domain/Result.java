package domain;

import domain.exception.EmptyResultException;

import java.util.Objects;

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

    public int length() {
        return result.length();
    }

    public String getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
        return Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return result;
    }
}
