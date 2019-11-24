package domain;

import domain.exception.InvalidPlayersException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_PLAYERS_COUNT = 2;
    private static final String NAME_DELIMITER = ",";

    private final List<Player> players;

    public Players(final String namesInput) {
        List<String> names = extractPlayerNames(namesInput);
        validate(names);
        players = Collections.unmodifiableList(createPlayers(names));
    }

    private List<String> extractPlayerNames(final String playersInput) {
        return Arrays.stream(playersInput.split(NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(final List<String> playerNames) {
        validateSize(playerNames);
        validateDistinctName(playerNames);
    }

    private void validateSize(final List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYERS_COUNT) {
            throw new InvalidPlayersException("최소 " + MIN_PLAYERS_COUNT + "명의 참가자를 입력해야 합니다.");
        }
    }

    private void validateDistinctName(final List<String> playerNames) {
        if (playerNames.size() != new HashSet<>(playerNames).size()) {
            throw new InvalidPlayersException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private List<Player> createPlayers(final List<String> playerNames) {
        return playerNames.stream()
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int getPlayerSize() {
        return players.size();
    }

    public Player get(int index) {
        return players.get(index);
    }
}
