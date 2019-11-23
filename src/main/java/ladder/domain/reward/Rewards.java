package ladder.domain.reward;

import ladder.domain.common.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ladder.domain.common.Position.MIN_POSITION_BOUNDARY;

public class Rewards implements Iterable<Reward> {
    private static final String DELIMITER_NAMES = ",";

    private final List<Reward> rewards;

    public Rewards(final String inputRewards) {
        this.rewards = createRewards(inputRewards);
    }

    private List<Reward> createRewards(final String inputRewards) {
        final List<Reward> rewards = new ArrayList<>();
        int position = MIN_POSITION_BOUNDARY;
        for (final String name : inputRewards.split(DELIMITER_NAMES)) {
            rewards.add(Reward.of(name, Position.from(position++)));
        }
        return rewards;
    }

    public static Rewards of(final String inputRewards) {
        return new Rewards(inputRewards);
    }

    public int size() {
        return rewards.size();
    }

    @Override
    public Iterator<Reward> iterator() {
        return new Iterator<Reward>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < rewards.size();
            }

            @Override
            public Reward next() {
                return rewards.get(cursor++);
            }
        };
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
