package laddergame.domain.laddergoal;

import laddergame.exception.MismatchSizeBetweenGoalsAndPlayersException;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public List<String> getGoalNames() {
        return modifyWithFunction(LadderGoal::getName);
    }

    public List<String> getAlignedGoalNames() {
        return modifyWithFunction(LadderGoal::getAlignedName);
    }

    private List<String> modifyWithFunction(Function<LadderGoal, String> function) {
        return goals.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
