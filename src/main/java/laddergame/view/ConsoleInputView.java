package laddergame.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String inputLadderPlayerNames() {
        return inputWithMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    @Override
    public String inputLadderGoalNames() {
        return inputWithMessage("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    @Override
    public String inputLadderHeight() {
        return inputWithMessage("최대 사다리 높이는 몇 개인가요?");
    }

    @Override
    public String inputPlayerNameForResult() {
        return inputWithMessage("결과를 보고 싶은 사람은?(all : 모든 결과, exit : 게임 종료)");
    }

    private String inputWithMessage(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
