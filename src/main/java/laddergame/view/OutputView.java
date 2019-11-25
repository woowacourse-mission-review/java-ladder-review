package laddergame.view;

import laddergame.domain.LadderGame;

import java.util.Map;

public interface OutputView {
    void showExceptionMessage(Exception e);

    void showLadderGame(LadderGame ladderGame);

    void showResultOfPlayer(String resultOfPlayer);

    void showAllResultsOfPlayers(Map<String, String> allFinalResults);
}
