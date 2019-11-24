package laddergame;

import laddergame.domain.ladder.Results;
import laddergame.domain.user.Users;
import laddergame.view.InputMessage;
import laddergame.view.InputView;

public class App {
    public static void main(String[] args) {

        String names = InputView.inputLine(InputMessage.INPUT_NAME);
        Users users = Users.of(names);

        String scannedResults = InputView.inputLine(InputMessage.INPUT_RESULT);
        Results results = Results.of(scannedResults);
    }
}