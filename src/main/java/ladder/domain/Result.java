package ladder.domain;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;

public class Result {
    private final Player player;
    private final Reward reward;

    public Result(final Player player, final Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public String getPlayerName() {
        return player.getName();
    }

    public String getRewardName() {
        return reward.getName();
    }

    @Override
    public String toString() {
        return "Result{" +
                "player=" + player +
                ", reward=" + reward +
                '}';
    }
}
