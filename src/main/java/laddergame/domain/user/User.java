package laddergame.domain.user;

public class User {

    private final Name name;
    private final Position position;

    private User(final String name, final int position) {
        this.name = Name.of(name);
        this.position = Position.of(position);
    }

    public static User of(final String name, final int position) {
        return new User(name, position);
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }

    public boolean isPositionOf(final Position position) {
        return this.position.equals(position);
    }

    public void move(final int moveValue) {
        position.move(moveValue);
    }

    public boolean isEqualsName(final String name) {
        return this.name.isEquals(name);
    }

    public void moveRight() {
        position.moveRight();
    }

    public void moveLeft() {
        position.moveLeft();
    }
}
