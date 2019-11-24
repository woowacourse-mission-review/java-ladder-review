package laddergame.domain;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomLadderCreationStrategy;
import laddergame.domain.laddergoal.LadderGoals;
import laddergame.domain.ladderplayer.LadderPlayers;

public class LadderGame {

    private final LadderPlayers ladderPlayers;
    private final Ladder ladder;
    private final LadderGoals ladderGoals;

    private LadderGame(final LadderPlayers ladderPlayers, final LadderGoals ladderGoals, final LadderHeight ladderHeight) {
        this.ladderPlayers = ladderPlayers;
        this.ladderGoals = ladderGoals;

        this.ladder = Ladder.of(new RandomLadderCreationStrategy(), ladderPlayers.size(), ladderHeight.getHeight());
    }

    public static LadderGame of(final LadderPlayers ladderPlayers, final LadderGoals ladderGoals, final LadderHeight ladderHeight) {
        return new LadderGame(ladderPlayers, ladderGoals, ladderHeight);
    }
}
