package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static ladder.domain.ladder.Height.HEIGHT_MIN_BOUNDARY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {

    @Test
    void 논리적_동치성_테스트() {
        Height actual = Height.from(HEIGHT_MIN_BOUNDARY + 1);
        Height expected = Height.from(HEIGHT_MIN_BOUNDARY + 1);

        assertThat(actual).isEqualTo(expected);
        assertThat(actual == expected).isFalse();
    }

    @Test
    void 정상_생성_테스트() {
        int height = HEIGHT_MIN_BOUNDARY + 1;
        Height actual = Height.from(height);

        assertThat(actual.get()).isEqualTo(height);
    }

    @Test
    void 최소값_미만_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> Height.from(HEIGHT_MIN_BOUNDARY - 1));
    }
}