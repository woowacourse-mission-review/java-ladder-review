package laddergame.domain;

import laddergame.exception.LadderResultIndexNotFoundException;
import laddergame.exception.PlayerResultNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {

    private final List<String> playerNames;
    private final List<LadderLineResult> ladderLineResults;
    private final List<String> goalNames;

    public LadderGameResult(final List<String> playerNames, final List<LadderLineResult> ladderLineResults, final List<String> goalNames) {
        this.playerNames = playerNames;
        this.ladderLineResults = ladderLineResults;
        this.goalNames = goalNames;
    }

    public String findPlayerResultAtLineNumber(final int lineNumber, final String playerName) {
        if (playerNames.contains(playerName)) {
            int indexOfPlayer = playerNames.indexOf(playerName);
            Integer indexResultOfSource = findIndexOfSourceAtLine(lineNumber, indexOfPlayer);

            return goalNames.get(indexResultOfSource);
        }
        throw new PlayerResultNotFoundException();
    }

    private Integer findIndexOfSourceAtLine(final int lineNumber, final int sourceIndex) {
        try {
            int realIndexOfLineResult = lineNumber - 1;
            LadderLineResult ladderLineResult = ladderLineResults.get(realIndexOfLineResult);

            return ladderLineResult.findIndexOfSource(sourceIndex);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new LadderResultIndexNotFoundException(e);
        }
    }

    public String findFinalPlayerResult(final String playerName) {
        return findPlayerResultAtLineNumber(ladderLineResults.size(), playerName);
    }

    public Map<String, String> createAllFinalResults() {
        Map<String, String> finalResults = new HashMap<>();
        for (String playerName : playerNames) {
            finalResults.put(playerName, findFinalPlayerResult(playerName));
        }
        return finalResults;
    }
}
