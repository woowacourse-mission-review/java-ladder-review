package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_PLAYERS_COUNT = 2;

    List<Player> players;

    public Players(final String playersInput) {
        List<String> playerNames = Arrays.stream(playersInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        validate(playerNames);
    }

    private void validate(final List<String> playerNames) {
        validateSize(playerNames);
        validateDistinctName(playerNames);
    }

    private void validateSize(final List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYERS_COUNT) {
            throw new IllegalArgumentException("최소 " + MIN_PLAYERS_COUNT + "명의 참가자를 입력해야 합니다.");
        }
    }

    private void validateDistinctName(final List<String> playerNames) {
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }
    }
}
