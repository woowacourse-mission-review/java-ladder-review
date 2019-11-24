import controller.LadderGameController;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LadderGameController ladderGameController = new LadderGameController(inputView, outputView);

        try {
            ladderGameController.start();
        } catch (RuntimeException e) {
            outputView.showErrorMessage(e);
        }
    }
}
