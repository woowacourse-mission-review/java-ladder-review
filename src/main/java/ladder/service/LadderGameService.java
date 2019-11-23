package ladder.service;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.player.Players;

public class LadderGameService {

    private final LadderFactory ladderFactory;

    public LadderGameService(final LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public Ladder createLadder(int height, int countOfPlayers) {
        return ladderFactory.create(Height.from(height), countOfPlayers);
    }

    public Players createPlayers(final String inputNames) {
        return Players.of(inputNames);
    }
}
