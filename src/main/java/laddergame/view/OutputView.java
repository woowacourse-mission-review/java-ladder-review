package laddergame.view;

import laddergame.domain.LadderGame;

public interface OutputView {
    void showExceptionMessage(Exception e);

    void showLadderGame(LadderGame ladderGame);
}
