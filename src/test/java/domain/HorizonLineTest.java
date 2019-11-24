package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static domain.LinkedStatus.LINKED;
import static domain.LinkedStatus.UNLINKED;
import static org.assertj.core.api.Assertions.assertThat;

public class HorizonLineTest {
    @Test
    @DisplayName("사다리 내려오기 잘 동작하는지 확인")
    void go_down_test() {
        HorizonLine horizonLine = new HorizonLine(Arrays.asList(LINKED, UNLINKED));
        HorizonLineResult horizonLineResult = new HorizonLineResult(3);

        Players players = new Players("A,B,C");
        Rewards rewards = new Rewards("1,2,3", 3);

        horizonLine.goDown(horizonLineResult);
        Map<Player, Reward> results = horizonLineResult.link(players, rewards);

        assertThat(results.get(new Player("A"))).isEqualTo(new Reward("2"));
        assertThat(results.get(new Player("B"))).isEqualTo(new Reward("1"));
        assertThat(results.get(new Player("C"))).isEqualTo(new Reward("3"));
    }
}
