package games.laddergame;

import games.gamecomponent.Game;
import games.laddergame.domain.*;
import games.laddergame.domain.ladder.Ladder;
import games.laddergame.domain.ladder.ladderrowmaker.DefaultLadderRowMaker;
import games.laddergame.domain.ladder.ladderrowmaker.LadderRowMakers;
import games.laddergame.view.OutputView;
import games.library.ObjectMakingStrategy;
import games.library.ObjectMakingTemplate;
import games.view.InputView;

import java.util.List;

public class LadderGame implements Game {
    private static final String GAME_NAME = "LADDER";
    private static final String REGISTER_PLAYERS_MESSAGE = "규칙을 따라서 참가지 이름을 입력해 주세요!";
    private static final String REGISTER_PRIZES_MESSAGE = "규칙을 따라서 상품 이름을 입력해 주세요!";

    private InputView inputView;
    private OutputView outputView;
    private ObjectMakingTemplate objectMakingTemplate;

    public LadderGame() {
        this.inputView = InputView.getInstance();
        this.outputView = new OutputView();
        this.objectMakingTemplate = ObjectMakingTemplate.getInstance();
    }

    @Override
    public boolean isPlayable(String gameName) {
        return GAME_NAME.equals(gameName);
    }

    @Override
    public void start() {
        GameComponents players = registerComponents(REGISTER_PLAYERS_MESSAGE, Player::new, true);
        GameComponents prizes = registerComponents(REGISTER_PRIZES_MESSAGE, Prize::new, false);
        Height height = registerHeight();
        Ladder ladder = new Ladder(players.size(), height.getHeight(), new LadderRowMakers(players.size(), height.getHeight()));
        GameResult gameResult = ladder.climbDownLadder(players, prizes);
        endGame(gameResult);
    }

    private void endGame(GameResult gameResult) {
        outputView.printGameResult(gameResult);
        String userInput = inputView.askUserInput("결과를 보고싶은 사람의 이름을 입력해주세요!");
        outputView.printUserInquiry(userInput, gameResult.organizeResults());
    }

    public GameComponents registerComponents(String message, ObjectMakingStrategy strategy, boolean isDuplicateCheckNecessary) {
        GameComponents components;
        do {
            String rawData = inputView.askUserInput(message);
            components = new GameComponents(createMultipleObjects(rawData, strategy), isDuplicateCheckNecessary);
        } while (components.isNotSuccessfullyMade());
        return components;
    }


    public List<GameComponent> createMultipleObjects(String rawData, ObjectMakingStrategy strategy) {
        try {
            return objectMakingTemplate.createObjects(rawData, strategy);
        } catch (Exception e) {
            return null;
        }
    }

    private Height registerHeight() {
        String rawHeight = inputView.askUserInput("사다리의 높이를 알려주십시오!");
        Height height = new Height(rawHeight);
        return height;
    }
}
