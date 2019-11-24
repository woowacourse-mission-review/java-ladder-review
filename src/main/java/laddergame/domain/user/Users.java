package laddergame.domain.user;

import com.google.common.collect.Lists;
import laddergame.domain.ladder.exception.UserNotFoundException;

import java.util.List;

public class Users {

    private final List<User> users;

    private Users(final String namesWithComma) {
        this.users = initUsers(namesWithComma);
    }

    public static Users of(final String namesWithComma) {
        return new Users(namesWithComma);
    }

    private List<User> initUsers(final String namesWithComma) {
        List<User> users = Lists.newArrayList();
        String[] names = namesWithComma.split(",");
        for (int position = 0; position < names.length; position++) {
            users.add(User.of(names[position], position));
        }
        return users;
    }

    public int getSize() {
        return users.size();
    }

    public User getUserOf(final Position position) {
        return users.stream().filter(user -> user.isPositionOf(position))
            .findAny()
            .orElseThrow(UserNotFoundException::new);
    }
}
