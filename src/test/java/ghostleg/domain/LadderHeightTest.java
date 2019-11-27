package ghostleg.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {
    @Test
    void atLeastOne() {
        assertThrows(IllegalArgumentException.class, () -> new LadderHeight(0));
    }

    @Test
    void atMost1000() {
        assertThrows(IllegalArgumentException.class, () -> new LadderHeight(1001));
    }
}