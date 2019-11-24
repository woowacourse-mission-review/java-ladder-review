package ghostleg;

public class Player {
    private final PlayerName name;
    private final Position position;

    public Player(PlayerName name, Position initialPosition) {
        this.name = name;
        this.position = initialPosition;
    }

    public Position getPosition() {
        return position;
    }

    public void move(Direction direction) {
        position.add(direction.next());
    }
}
