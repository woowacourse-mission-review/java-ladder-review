package laddergame.domain.ladder;

import com.google.common.collect.Lists;

import java.util.List;

public class Results {

    private final List<Result> results;

    private Results(final String resultsWithComma) {
        this.results = initResults(resultsWithComma);
    }

    public static Results of(final String resultsWithComma) {
        return new Results(resultsWithComma);
    }

    private List<Result> initResults(final String resultsWithComma) {
        List<Result> results = Lists.newArrayList();
        String[] resultsStr = resultsWithComma.split(",");

        for (int position = 0; position < resultsStr.length; position++) {
            results.add(Result.of(resultsStr[position], position));
        }
        return results;
    }
}
