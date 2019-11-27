package ghostleg.controller;

import ghostleg.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GhostLeg {
    private final Players players;
    private final Rewards rewards;
    private final Ladder ladder;
    private Results results;

    public GhostLeg(List<String> playerNames, List<String> rewardNames, int height) {
        NumOfPlayers numOfPlayers = new NumOfPlayers(playerNames.size());
        LadderHeight ladderHeight = new LadderHeight(height);
        Players players = new Players(Player.newInstances(playerNames, numOfPlayers));
        List<Reward> rewards = rewardNames.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
        Ladder ladder = LadderMaker.newInstance(numOfPlayers, ladderHeight);

        this.players = players;
        this.rewards = new Rewards(rewards, numOfPlayers);
        this.ladder = ladder;
    }

    public void goDown() {
        while (!ladder.end()) {
            players.goDown(ladder.proceed());
        }

        results = new Results(players, rewards);
    }

    public Reward getResultOf(String playerName) {
        return results.get(playerName);
    }

    public Map<PlayerName, Reward> getAllResults() {
        return results.getAll();
    }

    public Players getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Rewards getRewards() {
        return rewards;
    }
}
