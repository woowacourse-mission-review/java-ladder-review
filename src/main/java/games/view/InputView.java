package games.view;

import java.util.Scanner;

public class InputView {
    public static final String DELIMITER = ",";
    private static final Scanner READER = new Scanner(System.in);

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String askUserInput(String message) {
        System.out.println(message);
        return READER.nextLine();
    }

    public static class LazyHolder {
        private static InputView INSTANCE = new InputView();
    }
}
