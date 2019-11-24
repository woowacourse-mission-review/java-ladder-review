package domain;

import domain.exception.DifferentSizeFromNameException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(List<String> results, int nameSize) {
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList())
        ;

        if (this.results.size() != nameSize) {
            throw new DifferentSizeFromNameException();
        }
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
