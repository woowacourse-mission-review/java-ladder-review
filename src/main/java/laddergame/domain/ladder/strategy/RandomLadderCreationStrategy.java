package laddergame.domain.ladder.strategy;

import java.util.Random;

public class RandomLadderCreationStrategy implements LadderCreationStrategy {

    @Override
    public boolean createCrossBar() {
        return new Random().nextBoolean();
    }
}
