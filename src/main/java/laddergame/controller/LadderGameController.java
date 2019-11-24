package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderGameResult;
import laddergame.domain.LadderHeight;
import laddergame.domain.laddergoal.LadderGoals;
import laddergame.domain.ladderplayer.LadderPlayers;
import laddergame.service.LadderGameService;
import laddergame.view.InputView;
import laddergame.view.OutputView;

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

            showResults(ladderGame);
        } catch (IllegalArgumentException e) {
            outputView.showExceptionMessage(e);
        }
    }

    private void showResults(LadderGame ladderGame) {
        while (true) {
            try {
                String playerName = inputView.inputPlayerNameForResult();
            } catch (IllegalArgumentException e) {
                outputView.showExceptionMessage(e);
            }
        }
    }
}
