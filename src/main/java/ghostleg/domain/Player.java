package ghostleg.domain;

import com.google.common.collect.Lists;

import java.util.List;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(PlayerName name, Position initialPosition) {
        this.name = name;
        this.position = initialPosition;
    }

    public static List<Player> newInstances(List<String> playerNames, NumOfPlayers numOfPlayers) {
        List<Player> instances = Lists.newArrayList();
        for (int i = 0; i < playerNames.size(); i++) {
            instances.add(new Player(new PlayerName(playerNames.get(i)), new Position(i, numOfPlayers)));
        }
        return instances;
    }

    public Position getPosition() {
        return position;
    }

    public int getNumericPosition() { return position.getValue(); }

    public void move(Direction direction) {
        position.add(direction.next());
    }

    public PlayerName getName() {
        return name;
    }
}
