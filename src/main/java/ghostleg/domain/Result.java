package ghostleg.domain;

public class Result {
    private final PlayerName player;
    private final Reward reward;

    public Result(PlayerName player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public PlayerName getPlayer() {
        return player;
    }

    public Reward getReward() {
        return reward;
    }
}
