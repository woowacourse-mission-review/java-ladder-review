package laddergame.domain.ladder;

import laddergame.domain.user.Position;
import laddergame.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point의 우측 bridge가 true일 때 user의 Position 이동 확인")
    void moveUser() {
        Users users = Users.of("a,b,c");
        Point point = new Point(Position.of(0), Direction.first(true));
        point.moveUser(users);
        assertThat(users.getPositionOf("a")).isEqualTo(Position.of(1));
    }

    @Test
    @DisplayName("Point의 우측 bridge가 false일 때 User의 Position 이동하지 않는 것 확인")
    void cant_moveUser() {
        Users users = Users.of("a,b,c");
        Point point = new Point(Position.of(0), Direction.first(false));
        point.moveUser(users);
        assertThat(users.getPositionOf("a")).isEqualTo(Position.of(0));
    }
}