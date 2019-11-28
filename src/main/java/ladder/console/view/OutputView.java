package ladder.console.view;

import ladder.domain.Result;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;

import java.util.List;

public class OutputView {

    private static final String VERTICAL_LINE = "|";
    private static final String SUB_LINE_TRUE = "------";
    private static final String SUB_LINE_FALSE = "      ";

    public void printPlayers(final Players players) {
        final StringBuilder sb = new StringBuilder();
        players.forEach(player -> sb.append(String.format("%-6s", player.getName())));
        System.out.println(sb.toString());
    }

    public void printLadder(final Ladder ladder) {
        final StringBuilder sb = new StringBuilder();

        ladder.forEach(line -> {
            line.forEach(direction -> {
                sb.append(VERTICAL_LINE);
                sb.append(direction.isRight() ? SUB_LINE_TRUE : SUB_LINE_FALSE);
            });
            sb.append("\n");
        });

        System.out.print(sb.toString());
    }

    public void printRewards(final Rewards rewards) {
        final StringBuilder sb = new StringBuilder();
        rewards.forEach(reward -> sb.append(String.format("%-6s", reward.getName())));
        System.out.println(sb.toString());
    }

    public void printResult(final List<Result> results) {
        System.out.println("실행 결과");
        results.forEach(result ->
                System.out.println(result.getPlayerName() + " : " + result.getRewardName()));
        System.out.println();
    }
}
