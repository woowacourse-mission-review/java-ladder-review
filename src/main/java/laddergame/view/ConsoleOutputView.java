package laddergame.view;

import laddergame.domain.LadderGame;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ConsoleOutputView implements OutputView {

    private static final String EXCEPTION_INFO_MESSAGE = "ERROR : ";
    private static final String LADDER_NAME_DELIMITER = " ";
    private static final String RESULT_INFO_MESSAGE = "실행 결과";

    @Override
    public void showExceptionMessage(final Exception e) {
        System.out.println(EXCEPTION_INFO_MESSAGE + e.getMessage());
    }

    @Override
    public void showLadderGame(final LadderGame ladderGame) {
        showAlignedPlayerNames(ladderGame);

        showLadder(ladderGame);

        showAlignedGoalNames(ladderGame);
    }

    private void showAlignedGoalNames(final LadderGame ladderGame) {
        List<String> alignedGoalNames = ladderGame.getAlignedGoalNames();
        System.out.println(StringUtils.join(alignedGoalNames, LADDER_NAME_DELIMITER));
    }

    private void showLadder(final LadderGame ladderGame) {
        List<String> lines = ladderGame.getStringsOfLadder();
        for (String line : lines) {
            System.out.println(line);
        }
    }

    private void showAlignedPlayerNames(final LadderGame ladderGame) {
        List<String> alignedPlayerNames = ladderGame.getAlignedPlayerNames();
        System.out.println(StringUtils.join(alignedPlayerNames, LADDER_NAME_DELIMITER));
    }

    @Override
    public void showResultOfPlayer(final String resultOfPlayer) {
        System.out.println(RESULT_INFO_MESSAGE);
        System.out.println(resultOfPlayer);
        System.out.println();
    }

    @Override
    public void showAllResultsOfPlayers(final Map<String, String> allFinalResults) {
        System.out.println(RESULT_INFO_MESSAGE);
        for (Map.Entry<String, String> entry : allFinalResults.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
