package laddergame.domain.laddergoal;

import laddergame.domain.name.LadderPlayerName;
import laddergame.exception.MismatchSizeBetweenGoalsAndPlayersException;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGoalsTest {

    private LadderGoals ladderGoals;

    @BeforeEach
    void setUp() {
        List<LadderGoal> goals = Arrays.asList(LadderGoal.from("one"), LadderGoal.from("two"), LadderGoal.from("three"));
        ladderGoals = LadderGoals.create(goals, 3);
    }

    @Test
    void create_MismatchNumOfGoalsException() {
        List<LadderGoal> goals = Arrays.asList(LadderGoal.from("one"), LadderGoal.from("two"), LadderGoal.from("three"));
        Exception exception = assertThrows(MismatchSizeBetweenGoalsAndPlayersException.class, () -> LadderGoals.create(goals, 2));

        assertThat(exception.getMessage()).isEqualTo(MismatchSizeBetweenGoalsAndPlayersException.MISMATCH_SIZE_BETWEEN_GOALS_AND_PLAYERS_MESSAGE);
    }

    @Test
    void getGoalNames() {
        List<String> goalNames = ladderGoals.getGoalNames();

        assertThat(goalNames.size()).isEqualTo(3);
        assertThat(goalNames.contains("one")).isTrue();
        assertThat(goalNames.contains("two")).isTrue();
        assertThat(goalNames.contains("three")).isTrue();
    }

    @Test
    void getAlignedGoalNames() {
        List<String> alignedGoalNames = ladderGoals.getAlignedGoalNames();
        for (String alignedGoalName : alignedGoalNames) {
            int numOfBlanks = LadderPlayerName.MAX_LEN_OF_PLAYER_NAME - alignedGoalName.length();

            String expected = alignedGoalName + StringUtils.repeat(" ", numOfBlanks);

            assertThat(alignedGoalName).isEqualTo(expected);
        }
    }
}