package controller;

import domain.Height;
import domain.HorizonLines;
import domain.Players;
import domain.Rewards;
import service.LadderGame;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private static final int INITIAL_REPEAT_COUNT = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame = new LadderGame();

    public LadderGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Players players = inputPlayerNames(INITIAL_REPEAT_COUNT);
        Rewards rewards = inputRewards(INITIAL_REPEAT_COUNT);
        inputHeight(INITIAL_REPEAT_COUNT);

        HorizonLines horizonLines = ladderGame.createLadder();
        ladderGame.goDown();

        outputView.showLadder(players, horizonLines, rewards);

        String resultInput;
        while (!"all".equals(resultInput = inputView.inputResult())) {
            showReward(resultInput);
        }
        outputView.showRewards(ladderGame.getResults());
    }

    private Players inputPlayerNames(final int repeatCount) {
        try {
            return ladderGame.registerPlayers(inputView.inputPlayerNames(repeatCount));
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return inputPlayerNames(repeatCount + 1);
        }
    }

    private Rewards inputRewards(final int repeatCount) {
        try {
            return ladderGame.registerRewards(inputView.inputRewards(repeatCount));
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return inputRewards(repeatCount + 1);
        }
    }

    private Height inputHeight(final int repeatCount) {
        try {
            return ladderGame.registerHeight(inputView.inputHeight(repeatCount));
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return inputHeight(repeatCount + 1);
        }
    }

    private void showReward(final String resultInput) {
        try {
            outputView.showReward(ladderGame.getResult(resultInput));
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
        }
    }
}
