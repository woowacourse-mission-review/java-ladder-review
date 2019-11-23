package ladder.domain;

import org.junit.jupiter.api.Test;

import static ladder.domain.Position.POSITION_BOUNDARY;
import static ladder.domain.Position.POSITION_CACHE_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PositionTest {

    @Test
    void 캐싱_테스트() {
        Position position1 = Position.from(1);
        Position position2 = Position.from(1);

        assertThat(position1 == position2).isTrue();
    }

    @Test
    void 캐싱이_안되어있을때_생성하면_캐싱해주는지_확인() {
        Position position1 = Position.from(POSITION_CACHE_SIZE + 10);
        Position position2 = Position.from(POSITION_CACHE_SIZE + 10);

        assertThat(position1 == position2).isTrue();
    }

    @Test
    void 최소값_미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Position.from(POSITION_BOUNDARY - 1));
    }

    @Test
    void Position_changeTest() {
        Position position = Position.from(1);
        Position changedPosition = position.change(-1);

        assertThat(changedPosition.get()).isEqualTo(0);
    }
}