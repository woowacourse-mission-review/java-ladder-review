package ghostleg.domain;

import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards, NumOfPlayers numOfPlayers) {
        validateNumOfRewards(rewards, numOfPlayers);
        this.rewards = rewards;
    }

    private void validateNumOfRewards(List<Reward> rewards, NumOfPlayers numOfPlayers) {
        if (rewards.size() != numOfPlayers.getValue()) {
            throw new IllegalArgumentException("보상의 수는 플레이어의 수와 일치해야합니다.");
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
