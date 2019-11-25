package laddergame.domain;

import laddergame.domain.laddergoal.LadderGoal;
import laddergame.domain.laddergoal.LadderGoals;
import laddergame.domain.ladderplayer.LadderPlayer;
import laddergame.domain.ladderplayer.LadderPlayers;
import laddergame.domain.result.LadderGameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        List<LadderPlayer> playerList = Arrays.asList(LadderPlayer.from("red"), LadderPlayer.from("blue"), LadderPlayer.from("green"));
        LadderPlayers ladderPlayers = LadderPlayers.create(playerList);

        List<LadderGoal> goalList = Arrays.asList(LadderGoal.from("one"), LadderGoal.from("two"), LadderGoal.from("three"));
        LadderGoals ladderGoals = LadderGoals.create(goalList, ladderPlayers.size());

        LadderHeight ladderHeight = LadderHeight.from(3);

        ladderGame = LadderGame.of(ladderPlayers, ladderGoals, ladderHeight, () -> true);
    }

    @Test
    void create() {
        assertThat(ladderGame).isNotNull();
    }

    @Test
    void proceed() {
        LadderGameResult ladderGameResult = ladderGame.proceed();

        assertThat(ladderGameResult.findPlayerResultAtLineNumber(1, "red")).isEqualTo("two");
        assertThat(ladderGameResult.findPlayerResultAtLineNumber(2, "red")).isEqualTo("one");
        assertThat(ladderGameResult.findPlayerResultAtLineNumber(3, "red")).isEqualTo("two");
    }
}