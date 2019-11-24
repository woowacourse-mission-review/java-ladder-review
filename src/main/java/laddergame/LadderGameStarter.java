package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.view.ConsoleInputView;
import laddergame.view.ConsoleOutputView;

public class LadderGameStarter {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new ConsoleInputView(), new ConsoleOutputView());
        ladderGameController.run();
    }
}
