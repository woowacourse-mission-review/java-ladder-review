package service;

import domain.*;

public class LadderGame {
    private Players players;
    private Height height;
    private Rewards rewards;
    private Ladder ladder;
    private GameResult gameResult;

    public Players registerPlayers(final String playersInput) {
        players = new Players(playersInput);
        return players;
    }

    public Height registerHeight(final String heightInput) {
        height = new Height(heightInput);
        return height;
    }

    public Rewards registerRewards(final String rewardsInput) {
        rewards = new Rewards(rewardsInput, players.getPlayerSize());
        return rewards;
    }

    public HorizonLines createLadder() {
        ladder = new Ladder(players.getPlayerSize(), height);
        return ladder.getHorizonLines();
    }

    public void goDown() {
        gameResult = ladder.goDown(players, rewards);
    }

    public Reward getResult(String playerInput) {
        Player player = new Player(playerInput);
        return gameResult.getResult(player);
    }

    public GameResult getResults() {
        return gameResult;
    }
}
