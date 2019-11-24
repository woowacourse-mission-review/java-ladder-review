package view;

import java.util.Scanner;

public class InputView {
    private static final int MAX_REPEAT_COUNT = 5;

    private Scanner scanner = new Scanner(System.in);

    public String inputPlayerNames(final int repeatCount) {
        checkRepeatCount(repeatCount);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String inputHeight(final int repeatCount) {
        checkRepeatCount(repeatCount);
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextLine();
    }

    public String inputRewards(final int repeatCount) {
        checkRepeatCount(repeatCount);
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String inputResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private void checkRepeatCount(final int repeatCount) {
        if (repeatCount > MAX_REPEAT_COUNT) {
            throw new RepeatCountExceedException();
        }
    }
}
