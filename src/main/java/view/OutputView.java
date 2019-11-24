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
        for (int i = 0; i < players.getPlayerSize(); i++) {
            sb.append(String.format("%5s", players.get(i).getName()));
        }
        sb.append("\n");
        for (HorizonLine horizonLine : horizonLines) {
            sb.append("  ");
            for (LinkedStatus linkedStatus : horizonLine) {
                sb.append("|");
                if (linkedStatus.equals(LINKED)) {
                    sb.append("-----");
                } else {
                    sb.append("     ");
                }
            }
            sb.append("|    \n");
        }
        for (int i = 0; i < players.getPlayerSize(); i++) {
            sb.append(String.format("%5s", rewards.get(i).getReward()));
        }
        sb.append("\n");
        System.out.println(sb.toString());
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
