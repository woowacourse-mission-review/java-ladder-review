package ghostleg.view;

import ghostleg.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleOutputView implements GhostLegOutputView {
    private static final int PADDING_WIDTH = 5;

    @Override
    public void printPlayers(List<Player> players) {
        System.out.println(players.stream()
                .map(Player::getName)
                .map(PlayerName::getValue)
                .map(name -> StringUtils.center(name, PADDING_WIDTH))
                .collect(Collectors.joining())
        );
    }

    @Override
    public void printLadder(Ladder ladder) {
        System.out.println(ladder.getLines().stream()
                .map(this::lineToString)
                .collect(Collectors.joining("\n"))
        );
    }

    private String lineToString(Line line) {
        return "  |" + line.getPoints().stream()
                .map(this::pointToString)
                .collect(Collectors.joining("|")) + "|";
    }

    private String pointToString(Point point) {
        return point.next() == Direction.RIGHT ? "-----" : "     ";
    }

    @Override
    public void printRewards(List<Reward> rewards) {
        System.out.println(rewards.stream()
                .map(Reward::getName)
                .map(name -> StringUtils.center(name, PADDING_WIDTH))
                .collect(Collectors.joining())
        );
    }

    @Override
    public void printResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result.getReward());
    }

    @Override
    public void printAllResults(List<Result> results) {
        System.out.println("실행 결과");
        System.out.println(results.stream()
                .map(result -> String.format("%s : %s", result.getPlayer().getName().getValue(), result.getReward().getName()))
                .collect(Collectors.joining("\n"))
        );
    }
}
