package ghostleg;

import ghostleg.controller.GhostLeg;
import ghostleg.view.ConsoleInputView;
import ghostleg.view.ConsoleOutputView;
import ghostleg.view.GhostLegInputView;
import ghostleg.view.GhostLegOutputView;

public class GhostLegApp {
    public static void main(String[] args) {
        GhostLegInputView inputView = new ConsoleInputView();
        GhostLegOutputView outputView = new ConsoleOutputView();

        GhostLeg ghostLegGame = new GhostLeg(inputView.inputPlayerNames(), inputView.inputRewards(), inputView.inputLadderHeight());
        outputView.printPlayers(ghostLegGame.getPlayers());
        outputView.printLadder(ghostLegGame.getLadder());
        outputView.printRewards(ghostLegGame.getRewards());
        ghostLegGame.goDown();
        String query;

        while (!(query = inputView.inputResultQuery()).equals("all")) {
            outputView.printResult(ghostLegGame.getResultOf(query));
        }

        outputView.printAllResults(ghostLegGame.getAllResults());
    }
}
