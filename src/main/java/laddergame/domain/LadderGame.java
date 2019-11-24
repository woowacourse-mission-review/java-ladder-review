package laddergame.domain;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderCreationStrategy;
import laddergame.domain.ladder.RandomLadderCreationStrategy;
import laddergame.domain.laddergoal.LadderGoals;
import laddergame.domain.ladderplayer.LadderPlayers;
import laddergame.domain.name.LadderPlayerName;

import java.util.List;

public class LadderGame {

    private final LadderPlayers ladderPlayers;
    private final Ladder ladder;
    private final LadderGoals ladderGoals;

    private LadderGame(final LadderPlayers ladderPlayers, final LadderGoals ladderGoals, final LadderHeight ladderHeight
            , final LadderCreationStrategy strategy) {
        this.ladderPlayers = ladderPlayers;
        this.ladderGoals = ladderGoals;

        this.ladder = Ladder.of(strategy, ladderPlayers.size(), ladderHeight.getHeight());
    }

    public static LadderGame of(final LadderPlayers ladderPlayers, final LadderGoals ladderGoals
            , final LadderHeight ladderHeight, final LadderCreationStrategy strategy) {
        return new LadderGame(ladderPlayers, ladderGoals, ladderHeight, strategy);
    }

    public static LadderGame createWithRandomCreationStrategy(final LadderPlayers ladderPlayers
            , final LadderGoals ladderGoals, final LadderHeight ladderHeight) {
        return of(ladderPlayers, ladderGoals, ladderHeight, new RandomLadderCreationStrategy());
    }

    public List<String> getAlignedPlayerNames() {
        return ladderPlayers.getAlignedPlayerNames();
    }

    public List<String> getAlignedGoalNames() {
        return ladderGoals.getAlignedGoalNames();
    }

    public List<String> getStringsOfLadder() {
        return ladder.getStringsOfLadderLines(LadderPlayerName.MAX_LEN_OF_PLAYER_NAME);
    }

    public LadderGameResult proceed() {
        List<String> playerNames = ladderPlayers.getPlayerNames();
        List<LadderLineResult> lineResults = ladder.createLineResults();
        List<String> goalNames = ladderGoals.getGoalNames();

        return new LadderGameResult(playerNames, lineResults, goalNames);
    }
}
