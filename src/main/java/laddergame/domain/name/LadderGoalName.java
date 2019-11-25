package laddergame.domain.name;

import laddergame.exception.ExcessOfGoalNameException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class LadderGoalName {

    private final Name goalName;

    public LadderGoalName(final String name) {
        Name newName = new Name(name);
        if (newName.isNameLengthGreaterThan(LadderPlayerName.MAX_LEN_OF_PLAYER_NAME)) {
            throw new ExcessOfGoalNameException();
        }

        this.goalName = newName;
    }

    public String getName() {
        return goalName.getInnerName();
    }

    public String getAlignedName() {
        return StringUtils.rightPad(getName(), LadderPlayerName.MAX_LEN_OF_PLAYER_NAME);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderGoalName that = (LadderGoalName) o;
        return Objects.equals(goalName, that.goalName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goalName);
    }
}
