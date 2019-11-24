package laddergame;

import laddergame.domain.ladder.Height;
import laddergame.domain.ladder.LadderGame;
import laddergame.domain.ladder.Lines;
import laddergame.domain.ladder.LinesGenerator;
import laddergame.domain.ladder.Results;
import laddergame.domain.user.Position;
import laddergame.domain.user.Users;
import laddergame.view.InputMessage;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class App {
    public static void main(String[] args) {

        String names = InputView.inputLine(InputMessage.INPUT_NAME);
        Users users = Users.of(names);

        String scannedResults = InputView.inputLine(InputMessage.INPUT_RESULT);
        Results results = Results.of(scannedResults);

        int scannedHeight = InputView.inputNumber(InputMessage.INPUT_HEIGHT);
        Height height = Height.of(scannedHeight);

        LinesGenerator linesGenerator = new LinesGenerator(users.getSize(), height);
        Lines lines = linesGenerator.generateLines();

        LadderGame ladderGame = new LadderGame(lines, users);
        ladderGame.playGame();

        OutputView.printLadder(users, lines, results);

        String name;
        while (!"all".equals(name = InputView.inputLine(InputMessage.INPUT_RESULT_OF_USER))) {
            Position userPosition = users.getPositionOf(name);
            OutputView.printResultOf(results.getResultOf(userPosition));
        }
        OutputView.printAllResult(users, results);
    }
}