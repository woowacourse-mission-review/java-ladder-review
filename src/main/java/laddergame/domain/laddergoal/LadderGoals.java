package laddergame.domain.laddergoal;

import laddergame.exception.MismatchSizeBetweenGoalsAndPlayersException;

import java.util.List;

public class LadderGoals {

    private final List<LadderGoal> goals;

    private LadderGoals(final List<LadderGoal> goals, final int sizeOfLadderPlayers) {
        if (mismatchSizeBetweenGoalsAndPlayers(goals, sizeOfLadderPlayers)) {
            throw new MismatchSizeBetweenGoalsAndPlayersException();
        }

        this.goals = goals;
    }

    private boolean mismatchSizeBetweenGoalsAndPlayers(final List<LadderGoal> goals, final int sizeOfLadderPlayers) {
        return goals.size() != sizeOfLadderPlayers;
    }

    public static LadderGoals create(final List<LadderGoal> goals, final int sizeOfLadderPlayers) {
        return new LadderGoals(goals, sizeOfLadderPlayers);
    }
}
