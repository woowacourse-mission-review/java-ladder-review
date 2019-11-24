package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.LinkedStatus.LINKED;
import static domain.LinkedStatus.UNLINKED;
import static org.assertj.core.api.Assertions.assertThat;

public class LinkedStatusTest {
    @Test
    @DisplayName("LINKED를 determine의 파라미터로 전달했을 때 UNLINKED 리턴")
    void determine_if_LINKED_passed() {
        assertThat(LinkedStatus.determine(LINKED)).isEqualTo(UNLINKED);
    }
}
