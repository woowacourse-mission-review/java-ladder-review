package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DefaultLadderFactoryTest {

    @Test
    void 예외없이_생성_되는지_테스트() {
        LadderFactory ladderFactory = new DefaultLadderFactory();
        Height height = Height.from(2);
        int countOfPlayers = 2;

        assertDoesNotThrow(() -> ladderFactory.create(height, countOfPlayers));
    }
}