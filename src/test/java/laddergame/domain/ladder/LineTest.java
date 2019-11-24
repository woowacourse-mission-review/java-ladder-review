package laddergame.domain.ladder;

import laddergame.domain.user.Position;
import laddergame.domain.user.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void moveUsers() {
        Line line = new Line(Lists.newArrayList(new Point(Position.of(0), Direction.first(true)),
            new Point(Position.of(1), Direction.of(true,false))));

        Users users = Users.of("a,b");
        line.moveUsers(users);
        assertThat(users.getPositionOf("a")).isEqualTo(Position.of(1));
        assertThat(users.getPositionOf("b")).isEqualTo(Position.of(0));
    }
}