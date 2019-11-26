package games.utility;

import games.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommaParser {
    public static List<String> parse(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(InputView.DELIMITER)));
    }
}
