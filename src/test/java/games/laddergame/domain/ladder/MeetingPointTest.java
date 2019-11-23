package games.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MeetingPointTest {
    @Test
    @DisplayName("MeetingPoint생성 테스트1")
    void meeting_ponint_construct_test() {
        MeetingPoint point = new MeetingPoint(1, true);

        assertThat(point.getPosition()).isEqualTo(1);
        assertThat(point.isSwapOrNot()).isTrue();
    }

    @Test
    @DisplayName("오류, MeetingPoint생성 테스트")
    void fail_meeting_ponint_construct_test() {
        assertThrows(IllegalArgumentException.class, () -> new MeetingPoint(0, true));
    }
}