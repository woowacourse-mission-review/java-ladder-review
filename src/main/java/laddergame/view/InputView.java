package laddergame.view;

import java.util.Scanner;

public class InputView {

    public static String inputLine(InputMessage inputMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputMessage.getMessage());
        return scanner.nextLine();
    }

    public static int inputNumber(InputMessage inputMessage) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(inputMessage.getMessage());
        return scanner.nextInt();
    }
}
