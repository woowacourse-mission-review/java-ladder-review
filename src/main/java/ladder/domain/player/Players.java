package ladder.domain.player;

import ladder.domain.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.domain.Position.MIN_POSITION_BOUNDARY;

public class Players {
    private static final String DELIMITER_NAMES = ",";

    private final List<Player> players;

    private Players(final String inputNames) {
        List<PlayerName> names = parseNames(inputNames);
        checkDuplicateName(names);
        this.players = createPlayers(names);
    }

    public static Players of(final String inputNames) {
        return new Players(inputNames);
    }

    private List<PlayerName> parseNames(final String names) {
        return Stream.of(names.split(DELIMITER_NAMES))
                .map(PlayerName::from)
                .collect(Collectors.toList());
    }

    private void checkDuplicateName(final List<PlayerName> names) {
        Set<PlayerName> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    private List<Player> createPlayers(final List<PlayerName> names) {
        final List<Player> players = new ArrayList<>();
        int position = MIN_POSITION_BOUNDARY;
        for (final PlayerName name : names) {
            players.add(Player.of(name, Position.from(position++)));
        }
        return players;
    }

    public int size() {
        return players.size();
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
