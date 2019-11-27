package ghostleg.domain;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Results {
    private final Map<PlayerName, Reward> results;

    public Results(Players players, Rewards rewards) {
        this.results = Maps.newHashMap();
        List<Player> playerList = players.getPlayers();
        List<Reward> rewardList = rewards.getRewards();

        for (int i = 0; i < playerList.size(); i++) {
            results.put(playerList.get(i).getName(), rewardList.get(playerList.get(i).getPosition().getValue()));
        }
    }


    public Reward get(String playerName) {
        return results.get(new PlayerName(playerName));
    }

    public Map<PlayerName, Reward> getAll() {
        return results;
    }
}
