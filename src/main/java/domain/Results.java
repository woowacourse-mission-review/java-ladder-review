package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList())
        ;
    }
}
