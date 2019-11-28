package ladder.domain.reward;

import ladder.domain.common.Position;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RewardsTest {

    @Test
    void 생성_테스트() {
        Rewards rewards = Rewards.of("꽝,5000,꽝,3000");
        Iterator<Reward> iterator = rewards.iterator();

        assertThat(rewards.size()).isEqualTo(4);
        assertThat(iterator.next().getName()).isEqualTo("꽝");
        assertThat(iterator.next().getName()).isEqualTo("5000");
        assertThat(iterator.next().getName()).isEqualTo("꽝");
        assertThat(iterator.next().getName()).isEqualTo("3000");
    }

    @Test
    void getByPosition_없는_포지션_예외처리() {
        Rewards rewards = Rewards.of("꽝,5000,꽝,3000");

        assertThrows(IllegalArgumentException.class, () -> rewards.getByPosition(Position.from(100)));
    }
}