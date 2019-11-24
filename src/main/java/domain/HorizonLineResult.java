package domain;

import java.util.*;

public class HorizonLineResult {
    private List<Integer> playerPosition = new ArrayList<>();

    public HorizonLineResult(final int playersCount) {
        for (int i = 0; i < playersCount; i++) {
            playerPosition.add(i);
        }
    }

    public void swap(int i, int j) {
        Collections.swap(playerPosition, i, j);
    }

    public Map<Player, Reward> link(final Players players, final Rewards rewards) {
        Map<Player, Reward> result = new HashMap<>();
        int rewardIndex = 0;

        for (Integer playerIndex : playerPosition) {
            result.put(players.get(playerIndex), rewards.get(rewardIndex++));
        }

        return result;
    }
}
