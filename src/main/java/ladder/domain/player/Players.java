package ladder.domain.player;

import ladder.domain.common.Position;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.domain.common.Position.MIN_POSITION_BOUNDARY;

public class Players implements Iterable<Player> {
    private static final String DELIMITER_NAMES = ",";
    private static final int PLAYERS_MIN_BOUNDARY = 2;

    private final List<Player> players;

    private Players(final String inputNames) {
        List<PlayerName> names = parseNames(inputNames);
        validateCountOfPlayers(names);
        validateDuplicatedName(names);
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

    private List<Player> createPlayers(final List<PlayerName> names) {
        final List<Player> players = new ArrayList<>();
        int position = MIN_POSITION_BOUNDARY;
        for (final PlayerName name : names) {
            players.add(Player.of(name, Position.from(position++)));
        }
        return players;
    }

    private void validateCountOfPlayers(final List<PlayerName> names) {
        if (names.size() < PLAYERS_MIN_BOUNDARY) {
            throw new IllegalArgumentException("플레이어가 " + PLAYERS_MIN_BOUNDARY + "명 이상이어야 합니다.");
        }
    }

    private void validateDuplicatedName(final List<PlayerName> names) {
        Set<PlayerName> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public Player getByPlayerName(final String playerName) {
        return players.stream()
                .filter(player -> player.matchPlayerName(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
    }

    @Override
    public Iterator<Player> iterator() {
        return new Iterator<Player>() {
            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < players.size();
            }

            @Override
            public Player next() {
                return players.get(cursor++);
            }
        };
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
