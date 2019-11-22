package games.laddergame;

import games.gamecomponent.Game;
import games.laddergame.domain.Height;
import games.laddergame.domain.Players;
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
        Players players = registerPlayers();
        Height height = registerHeight();

    }

    private Height registerHeight() {
        String rawHeight = inputView.askUserInput("사다리의 높이를 알려주십시오!");
        Height height = new Height(rawHeight);
        return height;
    }

    private Players registerPlayers() {
        Players players;
        do {
            String rawPlayersNames = inputView.askUserInput("참여할 사람의 이름을 입력하세요.(이름은 쉼표로 구분합니다.)");
            players = new Players(rawPlayersNames);
            return players;
        } while (players.isNotSuccessfullyMade());
    }
}
