package laddergame.domain.laddergoal;

import laddergame.domain.name.LadderGoalName;

import java.util.Objects;

public class LadderGoal {

    private final LadderGoalName ladderGoalName;

    private LadderGoal(final String goalName) {
        this.ladderGoalName = new LadderGoalName(goalName);
    }

    public static LadderGoal from(final String goalName) {
        return new LadderGoal(goalName);
    }

    public String getName() {
        return ladderGoalName.getName();
    }

    public String getAlignedName() {
        return ladderGoalName.getAlignedName();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderGoal that = (LadderGoal) o;
        return Objects.equals(ladderGoalName, that.ladderGoalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderGoalName);
    }
}
