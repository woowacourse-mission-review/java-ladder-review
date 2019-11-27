package ghostleg.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public void goDown(List<Direction> directions) {
        validateNumOfDirections(directions);
        players = sortPlayersByPosition(players);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).move(directions.get(i));
        }
    }

    private List<Player> sortPlayersByPosition(List<Player> players) {
        return players.stream()
                .sorted(Comparator.comparingInt(Player::getNumericPosition))
                .collect(Collectors.toList());
    }

    private Player findPlayerOnPosition(int position) {
        return players.stream()
                .filter(player -> player.getPosition().getValue() == position)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 위치에 플레이어가 존재하지 않습니다."));
    }

    private void validateNumOfDirections(List<Direction> directions) {
        if (directions.size() != players.size()) {
            throw new IllegalArgumentException("플레이어의 수와 이동명령의 수가 일치해야 합니다.");
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
