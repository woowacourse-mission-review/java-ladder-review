package laddergame.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputLine(InputMessage inputMessage) {
        System.out.println(inputMessage.getMessage());
        return SCANNER.nextLine();
    }
}
