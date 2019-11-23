package ladder.domain;

import ladder.domain.common.Position;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;
import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.LadderGameInfo.ALL_RESULTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LadderGameInfoTest {
    private Players players = Players.of("bedi, cu, pobi");
    private Rewards rewards = Rewards.of("3000, 꽝, 3000");
    private Ladder ladder = mock(Ladder.class);
    private LadderGameInfo ladderGameInfo = new LadderGameInfo(players, rewards, ladder);

    @Test
    @DisplayName("Players와 Rewards의 size가 다를 경우 예외처리")
    void createException() {
        Players players = Players.of("bedi, cu, pobi");
        Rewards rewards = Rewards.of("3000, 꽝");
        Ladder ladder = mock(Ladder.class);

        assertThrows(IllegalStateException.class, () -> new LadderGameInfo(players, rewards, ladder));
    }

    @Test
    void getResultByPlayerName() {
        // given
        when(ladder.moveUntilEnd(Position.from(0))).thenReturn(Position.from(2));

        // when
        Result result = ladderGameInfo.getResults("bedi").get(0);

        // then
        assertThat(result.getRewardName()).isEqualTo("3000");
        assertThat(result.getPlayerName()).isEqualTo("bedi");
    }

    @Test
    void getResults() {
        // given
        when(ladder.moveUntilEnd(Position.from(0))).thenReturn(Position.from(0));
        when(ladder.moveUntilEnd(Position.from(1))).thenReturn(Position.from(1));
        when(ladder.moveUntilEnd(Position.from(2))).thenReturn(Position.from(2));

        // when
        List<Result> results = ladderGameInfo.getResults(ALL_RESULTS);

        // then
        assertThat(results.get(0).getRewardName()).isEqualTo("3000");
        assertThat(results.get(1).getRewardName()).isEqualTo("꽝");
        assertThat(results.get(2).getRewardName()).isEqualTo("3000");

    }
}