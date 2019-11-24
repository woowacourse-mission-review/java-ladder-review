package view;

import domain.*;

import static domain.LinkedStatus.LINKED;

public class OutputView {
    public void showErrorMessage(final RuntimeException e) {
        System.out.println(e.getMessage());
    }

    public void showLadder(final Players players, final HorizonLines horizonLines, final Rewards rewards) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n사다리 결과\n\n");
        appendPlayers(players, sb);
        appendLadder(horizonLines, sb);
        appendRewards(players, rewards, sb);
        System.out.println(sb.toString());
    }

    private void appendPlayers(final Players players, final StringBuffer sb) {
        for (int i = 0; i < players.getPlayerSize(); i++) {
            sb.append(String.format("%5s", players.get(i).getName()));
        }
        sb.append("\n");
    }

    private void appendLadder(final HorizonLines horizonLines, final StringBuffer sb) {
        for (HorizonLine horizonLine : horizonLines) {
            appendHorizonLine(sb, horizonLine);
        }
    }

    private void appendHorizonLine(final StringBuffer sb, final HorizonLine horizonLine) {
        sb.append("  ");
        for (LinkedStatus linkedStatus : horizonLine) {
            sb.append("|");
            appendLinkedStatus(sb, linkedStatus);
        }
        sb.append("|    \n");
    }

    private void appendLinkedStatus(final StringBuffer sb, final LinkedStatus linkedStatus) {
        if (linkedStatus.equals(LINKED)) {
            sb.append("-----");
            return;
        }
        sb.append("     ");
    }

    private void appendRewards(final Players players, final Rewards rewards, final StringBuffer sb) {
        for (int i = 0; i < players.getPlayerSize(); i++) {
            sb.append(String.format("%5s", rewards.get(i).getReward()));
        }
        sb.append("\n");
    }

    public void showReward(final Reward result) {
        System.out.println(result.getReward());
    }

    public void showRewards(final GameResult results) {
        System.out.println("\n실행 결과");
        results.forEach((player, reward)
                -> System.out.println(player.getName() + " : " + reward.getReward()));
    }
}
