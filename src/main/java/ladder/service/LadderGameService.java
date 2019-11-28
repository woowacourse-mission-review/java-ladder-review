package ladder.service;

import ladder.domain.LadderGameInfo;
import ladder.domain.Result;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;

import java.util.List;

public class LadderGameService {

    private final LadderFactory ladderFactory;

    public LadderGameService(final LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public Ladder createLadder(final int height, final int countOfPlayers) {
        return ladderFactory.create(Height.from(height), countOfPlayers);
    }

    public Players createPlayers(final String inputNames) {
        return Players.of(inputNames);
    }

    public Rewards createRewards(final String inputRewards) {
        return Rewards.of(inputRewards);
    }

    public LadderGameInfo createLadderGameInfo(final Players players, final Rewards rewards, final Ladder ladder) {
        return new LadderGameInfo(players, rewards, ladder);
    }

    public List<Result> createResults(final LadderGameInfo ladderGameInfo, final String playerName) {
        return ladderGameInfo.getResults(playerName);
    }
}
