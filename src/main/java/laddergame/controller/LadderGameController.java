package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderHeight;
import laddergame.domain.laddergoal.LadderGoals;
import laddergame.domain.ladderplayer.LadderPlayers;
import laddergame.domain.result.LadderGameResult;
import laddergame.service.LadderGameService;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.Map;

import static laddergame.service.LadderGameReservedKeywords.KEYWORD_FOR_ALL_RESULTS;
import static laddergame.service.LadderGameReservedKeywords.KEYWORD_FOR_EXITING_GAME;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGameService ladderGameService = new LadderGameService();

    public LadderGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            String playerNameInput = inputView.inputLadderPlayerNames();
            LadderPlayers ladderPlayers = ladderGameService.createPlayers(playerNameInput);

            String ladderGoalInput = inputView.inputLadderGoalNames();
            LadderGoals ladderGoals = ladderGameService.createGoals(ladderGoalInput, ladderPlayers.size());

            String ladderHeightInput = inputView.inputLadderHeight();
            LadderHeight ladderHeight = ladderGameService.createHeight(ladderHeightInput);

            LadderGame ladderGame = ladderGameService.createLadderGame(ladderPlayers, ladderGoals, ladderHeight);
            outputView.showLadderGame(ladderGame);

            LadderGameResult result = ladderGameService.proceedGame(ladderGame);

            showResults(result);
        } catch (IllegalArgumentException e) {
            outputView.showExceptionMessage(e);
        }
    }

    private void showResults(LadderGameResult result) {
        while (true) {
            String playerNameInput = inputView.inputPlayerNameForResult();
            if (KEYWORD_FOR_EXITING_GAME.equals(playerNameInput)) {
                return;
            }

            try {
                findAndShow(result, playerNameInput);
            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }

    private void findAndShow(final LadderGameResult result, final String playerNameInput) {
        if (KEYWORD_FOR_ALL_RESULTS.equals(playerNameInput)) {
            Map<String, String> allFinalResults = result.createAllFinalResults();
            outputView.showAllResultsOfPlayers(allFinalResults);
            return;
        }

        String resultOfPlayer = result.findFinalPlayerResult(playerNameInput);
        outputView.showResultOfPlayer(resultOfPlayer);
    }
}
