package laddergame.domain.user;

public class User {

    private final Name name;
    private final Position position;

    public User(final String name, final int position) {
        this.name = Name.of(name);
        this.position = Position.of(position);
    }

    public static User of(final String name, final int position) {
        return new User(name, position);
    }
}
