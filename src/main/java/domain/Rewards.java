package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private static final String NAME_DELIMITER = ",";

    private final List<Reward> rewards;

    public Rewards(final String rewardInput, final int playersCount) {
        List<String> rewardNames = extractRewardNames(rewardInput);
        validateSize(rewardNames, playersCount);
        rewards = Collections.unmodifiableList(createRewards(rewardNames));
    }

    private List<String> extractRewardNames(final String rewardInput) {
        return Arrays.stream(rewardInput.split(NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateSize(final List<String> rewardNames, final int playersCount) {
        if (rewardNames.size() != playersCount) {
            throw new IllegalArgumentException("참여할 사람과 같은 수의 결과를 입력해주세요.");
        }
    }

    private List<Reward> createRewards(final List<String> rewardNames) {
        return rewardNames.stream()
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public Reward get(int index) {
        return rewards.get(index);
    }
}
