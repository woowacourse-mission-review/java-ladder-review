package ladder.domain;

import ladder.domain.common.Position;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGameInfo {
    public static final String ALL_RESULTS = "all";

    private final Players players;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGameInfo(final Players players, final Rewards rewards, final Ladder ladder) {
        validateSameSize(players, rewards);
        this.players = players;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    private void validateSameSize(final Players players, final Rewards rewards) {
        if (players.size() != rewards.size()) {
            throw new IllegalStateException("인원수와 결과의 개수가 일치하지 않습니다.");
        }
    }

    public List<Result> getResults(final String playerName) {
        return ALL_RESULTS.equals(playerName)
                ? getAllResults()
                : getResultByPlayerName(playerName);
    }

    private List<Result> getAllResults() {
        final List<Result> results = new ArrayList<>();
        players.forEach(player -> {
            Reward reward = getReward(player);
            results.add(new Result(player, reward));
        });
        return results;
    }

    private List<Result> getResultByPlayerName(final String playerName) {
        final Player player = players.getByPlayerName(playerName);
        final Reward reward = getReward(player);
        return Collections.singletonList(new Result(player, reward));
    }

    private Reward getReward(final Player player) {
        final Position startPosition = player.getPosition();
        final Position endPosition = ladder.moveUntilEnd(startPosition);
        return rewards.getByPosition(endPosition);
    }
}
