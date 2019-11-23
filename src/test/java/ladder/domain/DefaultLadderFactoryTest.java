package ladder.domain;

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

    @Test
    void 유효하지않은_값_입력_예외처리_테스트() {
        LadderFactory ladderFactory = new DefaultLadderFactory();
        Height height = Height.from(1);
        int countOfPlayers = 2;

        assertDoesNotThrow(() -> ladderFactory.create(height, countOfPlayers));
    }
}