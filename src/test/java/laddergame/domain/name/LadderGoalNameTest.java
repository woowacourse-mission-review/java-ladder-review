package laddergame.domain.name;

import laddergame.exception.ExcessOfGoalNameException;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGoalNameTest {

    private LadderGoalName ladderGoalName;

    @BeforeEach
    void setUp() {
        ladderGoalName = new LadderGoalName("one");
    }

    @Test
    void create() {
        assertThat(ladderGoalName.getName()).isEqualTo("one");
    }

    @Test
    void equals() {
        assertThat(ladderGoalName).isEqualTo(new LadderGoalName("one"));
    }

    @Test
    void create_ExcessOfGoalNameException() {
        Exception exception = assertThrows(ExcessOfGoalNameException.class, () -> new LadderGoalName("second"));

        assertThat(exception.getMessage()).isEqualTo(ExcessOfGoalNameException.EXCESS_OF_GOAL_NAME_MESSAGE);
    }

    @Test
    void getAlignedName() {
        String goalName = ladderGoalName.getName();
        int numOfBlanks = LadderPlayerName.MAX_LEN_OF_PLAYER_NAME - goalName.length();

        String expected = goalName + StringUtils.repeat(" ", numOfBlanks);

        assertThat(ladderGoalName.getAlignedName()).isEqualTo(expected);
    }
}