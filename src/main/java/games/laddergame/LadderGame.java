package games.laddergame;

import games.gamecomponent.Game;
import games.view.InputView;
import games.view.OutputView;

public class LadderGame implements Game {
    private static final String GAME_NAME = "LADDER";
    private InputView inputView;
    private OutputView outputView;

    public LadderGame() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
    }

    @Override
    public boolean isPlayable(String gameName) {
        return GAME_NAME.equals(gameName);
    }

    @Override
    public void start() {


    }
}
