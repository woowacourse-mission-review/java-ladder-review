package laddergame.domain.laddergoal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGoalTest {

    private LadderGoal ladderGoal;

    @BeforeEach
    void setUp() {
        ladderGoal = LadderGoal.from("one");
    }

    @Test
    void create() {
        assertThat(ladderGoal.getName()).isEqualTo("one");
    }

    @Test
    void equals() {
        assertThat(ladderGoal).isEqualTo(LadderGoal.from("one"));
    }
}