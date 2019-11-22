package games.racinggame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner READER = new Scanner(System.in);
    public static final String DELIMITER = ",";

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public static class LazyHolder {
        private static InputView INSTANCE = new InputView();
    }


    public String askUserInput(String message) {
        System.out.println(message);
        return READER.nextLine();
    }
}
