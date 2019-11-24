package laddergame.domain.ladder;

import laddergame.domain.user.Users;

public class LadderGame {

    private final Lines lines;
    private final Users users;

    public LadderGame(final Lines lines, final Users users) {
        this.lines = lines;
        this.users = users;
    }

    public void playGame() {
        lines.moveUsers(users);
    }
}
