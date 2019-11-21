package games.racinggame.input;

import games.InputAsker;

import java.util.Scanner;

public class RacingGameInputAsker implements InputAsker {
    private static final Scanner READER = new Scanner(System.in);
    public static final String DELIMITER = "%&%";
    public static final int FIRST_INDEX = 0;
    public static final int LAST_INDEX = 1;

    @Override
    public String askInitialUserInput() {
        System.out.println("자동차 이름을 입력해주세요! 자동차 이름은 쉼표로 구분합니다!");
        String carNames = READER.nextLine();

        System.out.println("경기횟수를 입력해 주세요!");
        String totalTurns = READER.nextLine();

        return carNames + DELIMITER + totalTurns;
    }
}
