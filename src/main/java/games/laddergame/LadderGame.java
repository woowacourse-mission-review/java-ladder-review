package games.laddergame;

import games.gamecomponent.Game;
import games.laddergame.domain.*;
import games.library.ObjectMakingStrategy;
import games.library.ObjectMakingTemplate;
import games.view.InputView;
import games.view.OutputView;

import java.util.List;

public class LadderGame implements Game {
    private static final String GAME_NAME = "LADDER";
    private InputView inputView;
    private OutputView outputView;
    private ObjectMakingTemplate objectMakingTemplate;

    public LadderGame() {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.objectMakingTemplate = ObjectMakingTemplate.getInstance();
    }

    @Override
    public boolean isPlayable(String gameName) {
        return GAME_NAME.equals(gameName);
    }

    @Override
    public void start() {
        String rawPlayersNames = inputView.askUserInput("규칙대로 참가할 사람의 이름을 적어주세요");
        GameComponents players = registerComponents(rawPlayersNames, Player::new);

        String rawPrizeNames = inputView.askUserInput("규칙대로 참가할 사람의 이름을 적어주세요");
        GameComponents prizes = registerComponents(rawPrizeNames, Prize::new);

        Height height = registerHeight();
    }

    public GameComponents registerComponents(String rawData, ObjectMakingStrategy strategy) {
        GameComponents components;
        do {
            components = new GameComponents(createMultipleObjects(rawData, strategy));
            return components;
        } while (components.isNotSuccessfullyMade());
    }


    private List<GameComponent> createMultipleObjects(String rawData, ObjectMakingStrategy strategy) {
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
