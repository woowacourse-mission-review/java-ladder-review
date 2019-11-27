package ghostleg.view;

import ghostleg.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleOutputView implements GhostLegOutputView {
    private static final int PADDING_WIDTH = 5;

    @Override
    public void printPlayers(Players players) {
        System.out.println(players.getPlayers().stream()
                .map(Player::getName)
                .map(PlayerName::getValue)
                .map(name -> StringUtils.center(name, PADDING_WIDTH))
                .collect(Collectors.joining(" "))
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
        List<Point> points = line.getPoints();
        return "  |" + points.subList(0, points.size() -1).stream()
                .map(this::pointToString)
                .collect(Collectors.joining("|")) + "|";
    }

    private String pointToString(Point point) {
        return point.move() == Direction.RIGHT ? "-----" : "     ";
    }

    @Override
    public void printRewards(Rewards rewards) {
        System.out.println(rewards.getRewards().stream()
                .map(Reward::getName)
                .map(name -> StringUtils.center(name, PADDING_WIDTH))
                .collect(Collectors.joining(" "))
        );
    }

    @Override
    public void printResult(Reward result) {
        System.out.println("실행 결과");
        System.out.println(result.getName());
    }

    @Override
    public void printAllResults(Map<PlayerName, Reward> results) {
        System.out.println("실행 결과");
        System.out.println(results.entrySet().stream()
                .map(result -> String.format("%s : %s", result.getKey().getValue(), result.getValue().getName()))
                .collect(Collectors.joining("\n"))
        );
    }
}
