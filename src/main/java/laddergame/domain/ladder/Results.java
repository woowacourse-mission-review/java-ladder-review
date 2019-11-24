package laddergame.domain.ladder;

import com.google.common.collect.Maps;
import laddergame.domain.user.Position;

import java.util.Map;

public class Results {

    public static final String RESULT_DELIMITER = ",";
    private final Map<Position, Result> results;

    private Results(final String resultsWithComma) {
        this.results = initResults(resultsWithComma);
    }

    public static Results of(final String resultsWithComma) {
        return new Results(resultsWithComma);
    }

    private Map<Position, Result> initResults(final String resultsWithComma) {
        Map<Position, Result> results = Maps.newHashMap();
        String[] resultsStr = resultsWithComma.split(RESULT_DELIMITER);

        for (int position = 0; position < resultsStr.length; position++) {
            results.put(Position.of(position), Result.of(resultsStr[position]));
        }
        return results;
    }

    public String getResultOf(Position position) {
        return results.get(position).getResult();
    }
}
