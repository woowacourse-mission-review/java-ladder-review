package ghostleg.view;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements GhostLegInputView {
    private static final Scanner SC = new Scanner(System.in);

    @Override
    public List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Lists.newArrayList(SC.nextLine().split(","));
    }

    @Override
    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SC.nextLine());
    }

    @Override
    public List<String> inputRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Lists.newArrayList(SC.nextLine().split(","));
    }

    @Override
    public String inputResultQuery() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SC.nextLine();
    }
}
